package com.lihl.springcloud.alibaba.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA() {
		try {
			TimeUnit.SECONDS.sleep(1);//测试流控-线程数
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "------testA";
	}

	@GetMapping("/testB")
	public String testB() {
		return "------testB";
	}

}
