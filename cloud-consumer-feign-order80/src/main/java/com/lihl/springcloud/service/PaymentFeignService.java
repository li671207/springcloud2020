package com.lihl.springcloud.service;


import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

	@GetMapping(value = "/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

	@GetMapping(value = "/payment/feign/timeout")
	String getPaymentFeignTimeOut();
}
