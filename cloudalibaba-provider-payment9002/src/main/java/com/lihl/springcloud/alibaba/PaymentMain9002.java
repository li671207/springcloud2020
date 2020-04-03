package com.lihl.springcloud.alibaba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9002.class, args);
	}
}
