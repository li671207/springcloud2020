package com.lihl.springcloud.controller;

import com.lihl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String servicePort;

	/**
	 * 正常访问
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_OK(id);
		log.info("*****result:" + result);
		return result;
	}

	/**
	 * 超时访问
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_TimeOut(id);
		log.info("*****result:" + result);
		return result;

	}

	@GetMapping("/payment/circuit/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		String result = paymentService.paymentCircuitBreaker(id);
		log.info("*****result:" + result);
		return result;

	}
}
 
 
