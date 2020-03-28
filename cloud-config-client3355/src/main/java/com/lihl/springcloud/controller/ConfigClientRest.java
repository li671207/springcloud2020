package com.lihl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;

	@Value("${server.port}")
	private String port;

	@Value("${config.info}")
	private String configInfo;

	@RequestMapping("/config")
	public String getConfig()
	{
		String str = "applicationName: "+applicationName+"\t eurekaServers:"+eurekaServers+"\t port: "+port+"\t configInfo: "+configInfo;
		System.out.println("******str: "+ str);
		return str;
	}

}
