package com.lihl.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

public class FlowLimitController {

	@GetMapping("/testA")
	public String testA() {
//		try {
//			TimeUnit.SECONDS.sleep(1);//测试流控-线程数
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "------testA";
	}

	@GetMapping("/testB")
	public String testB() {
		log.info(Thread.currentThread().getName() + ".....testB");//流控-排队等待
		return "------testB";
	}

	@GetMapping("/testC")
	public String testC() {
//		try {
//			TimeUnit.SECONDS.sleep(1);//测试降级-RT
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		log.info("testC--->RT");

		log.info("testC--->异常比例");
		log.info(10 / 0 + "");//测试降级-异常比例

		return "------testC";
	}

	@GetMapping("/testD")
	public String testD() {
		log.info("testD--->异常数");
		log.info(10 / 0 + "");//测试降级-异常数

		return "------testD";
	}

	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "testHotKeyHandler")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
	                         @RequestParam(value = "p2", required = false) String p2) {
		log.info("testHotKey--->热点规则");

		return "------testHotKey";
	}

	public String testHotKeyHandler(@RequestParam(value = "p1", required = false) String p1,
	                                @RequestParam(value = "p2", required = false) String p2,
	                                BlockException exception) {
		log.info("testHotKeyHandler--->热点规则");

		return "------testHotKeyHandler";
	}

}
