package com.lihl.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService{
	@Override
	public String paymentInfo_OK(Integer id) {
		return "-------paymentInfo_OK------- O(∩_∩)O~";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		return "-------paymentInfo_TimeOut------- %>_<%";
	}
}
