package com.lihl.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("path_baidu_guonei" ,r->r.path("/guonei").uri("https://news.baidu.com/guonei"))
				.route("path_baidu_guoji" ,r->r.path("/guoji").uri("https://news.baidu.com/guoji"))
				.build();
	}
}
