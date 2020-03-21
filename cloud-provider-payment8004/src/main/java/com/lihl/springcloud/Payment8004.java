package com.lihl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//注册zookeeper或consul
public class Payment8004 {

	public static void main(String[] args) {
		SpringApplication.run(Payment8004.class, args);
	}
}
