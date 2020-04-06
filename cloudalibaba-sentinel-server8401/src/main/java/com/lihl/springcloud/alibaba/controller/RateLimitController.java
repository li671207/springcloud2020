package com.lihl.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihl.entities.CommonResult;
import com.lihl.entities.Payment;
import com.lihl.springcloud.alibaba.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "handlerException")
	public CommonResult byResource() {
		return new CommonResult(200, "资源名称限流测试OK", new Payment(1111L, "serial1111"));
	}

	public CommonResult handlerException(BlockException exception) {
		return new CommonResult(444, exception.getClass().getCanonicalName() + "  服务不可用");
	}

	@GetMapping("/rateLimit/byUrl")
	@SentinelResource(value = "byUrl")
	public CommonResult byUrl() {
		return new CommonResult(200, "url限流测试OK", new Payment(2222L, "serial2222"));
	}


	@GetMapping("/rateLimit/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1")
	public CommonResult customerBlockHandler() {
		return new CommonResult(200, "用户自定义限流测试OK", new Payment(3333L, "serial3333"));
	}

}
