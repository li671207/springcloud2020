package com.lihl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8006 {
	public static void main(String[] args) {
		SpringApplication.run(ConsulPaymentMain8006.class, args);
	}
}
