package com.lihl.springcloud.controller;

import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import com.lihl.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
	@Autowired
	private PaymentFeignService paymentFeignService;


	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping(value = "/consumer/payment/feign/timeout")
	public String getPaymentFeignTimeOut() {
		return paymentFeignService.getPaymentFeignTimeOut();
	}
}
