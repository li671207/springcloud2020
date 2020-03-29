package com.lihl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8802 {

	public static void main(String[] args) {
		SpringApplication.run(StreamMQMain8802.class, args);
	}
}
