package com.lihl.springcloud.alibaba.service;

import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

	@GetMapping("/paymentSql/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
