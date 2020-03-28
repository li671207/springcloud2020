package com.lihl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenter3344 {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCenter3344.class, args);
	}
}
