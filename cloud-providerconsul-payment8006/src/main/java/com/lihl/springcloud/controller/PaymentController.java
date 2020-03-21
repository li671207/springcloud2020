package com.lihl.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/payment/consul")
	public String paymentConsul() {
		return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
	}
}
