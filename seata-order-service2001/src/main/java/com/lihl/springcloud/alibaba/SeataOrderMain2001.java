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
public class SeataOrderMain2001 {


	public static void main(String[] args) {
		SpringApplication.run(SeataOrderMain2001.class, args);
	}

}
