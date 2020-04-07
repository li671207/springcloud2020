package com.lihl.springcloud.alibaba.service;

import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
	@Override
	public CommonResult<Payment> paymentSql(Long id) {
		return new CommonResult<>(444, "服务降级--->PaymentFallbackService", new Payment(id, "error"));
	}
}
