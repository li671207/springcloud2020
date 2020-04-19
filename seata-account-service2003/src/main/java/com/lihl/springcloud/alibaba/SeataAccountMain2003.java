package com.lihl.springcloud.alibaba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
//取消spring自动创建的datasource
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SeataAccountMain2003 {


	public static void main(String[] args) {
		SpringApplication.run(SeataAccountMain2003.class, args);
	}

}
