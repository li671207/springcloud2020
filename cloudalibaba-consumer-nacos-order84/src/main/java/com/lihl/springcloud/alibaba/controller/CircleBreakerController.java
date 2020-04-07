package com.lihl.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import com.lihl.springcloud.alibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircleBreakerController {
	public static final String SERVICE_URL = "http://nacos-payment-provider";

	@Autowired
	public RestTemplate restTemplate;
	@Autowired
	private PaymentService paymentService;


	@RequestMapping("/consumer/paymentSql/{id}")
	@SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler"
			, exceptionsToIgnore = {IllegalArgumentException.class})//fallback管运行异常,blockHandler管配置违规
	public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
		CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class, id);
		if (id == 4) {
			throw new IllegalArgumentException("IllegalArgumentException---->非法参数异常");
		} else if (result.getData() == null) {
			throw new NullPointerException("NullPointerException--->空指针异常");
		}

		return result;
	}

	@GetMapping("/consumer/paymentSql/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
		return paymentService.paymentSql(id);
	}

	public CommonResult handlerFallback(@PathVariable Long id, Throwable throwable) {
		Payment payment = new Payment(id, "null");

		return new CommonResult(444, "handlerFallback--->" + throwable.getMessage(), payment);
	}

	public CommonResult blockHandler(@PathVariable Long id, BlockException exception) {
		Payment payment = new Payment(id, "null");

		return new CommonResult(445, "blockHandler-sentinel--->" + exception.getMessage(), payment);
	}
}
