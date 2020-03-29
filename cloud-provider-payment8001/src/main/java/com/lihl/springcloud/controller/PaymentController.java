package com.lihl.springcloud.controller;


import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import com.lihl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@Resource
	private DiscoveryClient discoveryClient;


	@PostMapping("/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		if (result > 0) {
			return new CommonResult(200, "插入成功" + serverPort, result);
		} else {
			return new CommonResult(444, "插入失败！" + serverPort);
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("查询结果:" + payment);
		if (payment != null) {
			return new CommonResult(200, "查询成功,serverPort: " + serverPort, payment);
		} else {
			return new CommonResult(444, "没有对应记录，查询id:" + id);
		}
	}

	@GetMapping(value = "/payment/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		for (String element : services) {
			log.info("****element: " + element);
		}
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}

	@GetMapping(value = "/payment/lb")
	public String getPaymentLB() {
		return serverPort;
	}


	@GetMapping("/payment/feign/timeout")
	public String paymentFeignTimeOut() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return serverPort;
	}

	@GetMapping("/payment/zipkin")
	public String paymentZipkin() {
		return "zipkin......." + serverPort;
	}

}
