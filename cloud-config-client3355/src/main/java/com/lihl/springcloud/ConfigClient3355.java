package com.lihl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355 {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient3355.class, args);
	}
}
