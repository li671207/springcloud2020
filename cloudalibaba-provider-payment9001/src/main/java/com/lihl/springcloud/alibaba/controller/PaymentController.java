package com.lihl.springcloud.alibaba.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") Integer id) {
		return "payment nacos, ServerPort: " + serverPort + "   id---:" + id;
	}

}
