package com.lihl.springcloud.alibaba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

	@Value("${service-url.nacos-user-services}")
	private String serviceUrl;

	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/consumer/payment/nacos/{id}")
	public String paymentInfo(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
	}

}
