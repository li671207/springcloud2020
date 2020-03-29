package com.lihl.springcloud.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import com.lihl.springcloud.loadbalance.LoadBalance;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@CommonsLog
public class OrderController {

	//    public static final String PAYMENT_URL = "http://localhost:8001";
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private RestTemplate restTemplate;
	@Resource
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalance loadBalance;


	@PostMapping(value = "/consumer/payment/create")
	@ResponseBody
	public CommonResult<Payment> create(@RequestBody Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

		if (entity.getStatusCode().is2xxSuccessful()) {
			log.info(entity.getStatusCode() + "\t" + entity.getHeaders());
			return entity.getBody();
		} else {
			return new CommonResult<>(444, "操作失败");
		}
	}

	@GetMapping("/consumer/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if (CollectionUtil.isEmpty(instances)) {
			return null;
		}

		ServiceInstance serviceInstance = loadBalance.instance(instances);
		URI uri = serviceInstance.getUri();

		return restTemplate.getForObject(uri + "/payment/lb", String.class);

	}


	@GetMapping("/consumer/payment/zipkin")
	public String getPaymentZipkin() {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
	}
}
