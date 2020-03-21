package com.lihl.springcloud.controller;


import com.lihl.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CommonsLog
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

	@Autowired
	private PaymentHystrixService paymentHystrixService;

	/**
	 * 正常访问
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		return paymentHystrixService.paymentInfo_OK(id);
	}


	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
//	@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties={
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
	@HystrixCommand
	String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		int num=1/0;
		return paymentHystrixService.paymentInfo_TimeOut(id);
	}

	public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
		return "消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
	}

	public String payment_Global_FallbackMethod() {
		return "系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
	}
}
