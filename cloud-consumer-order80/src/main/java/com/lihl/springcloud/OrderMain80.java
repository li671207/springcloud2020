package com.lihl.springcloud;

import com.lihl.config.IRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = IRuleConfig.class)//自定义负载均衡算法
public class OrderMain80 {

	public static void main(String[] args) {

		SpringApplication.run(OrderMain80.class, args);
	}

}
