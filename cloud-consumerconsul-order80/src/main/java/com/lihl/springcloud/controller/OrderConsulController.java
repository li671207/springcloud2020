package com.lihl.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {
	public static final String INVOKE_URL = "http://cloud-provider-payment";


	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/consumer/payment/consul")
	public String paymentInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
	}

}
