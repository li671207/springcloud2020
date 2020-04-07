package com.lihl.springcloud.alibaba.controller;


import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

	public static Map<Long, Payment> paymentMap = new HashMap<>();

	static {
		paymentMap.put(1l, new Payment(1l, "serial101"));
		paymentMap.put(2l, new Payment(2l, "serial102"));
		paymentMap.put(3l, new Payment(3l, "serial103"));
	}

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/paymentSql/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
		return new CommonResult<>(200, "serverPort--->:" + serverPort, paymentMap.get(id));
	}
}
