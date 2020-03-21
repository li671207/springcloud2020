package com.lihl.springcloud.controller;


import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CommonsLog
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "payment/zk")
	public String paymentZk() {
		return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
	}
}
