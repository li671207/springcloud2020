package com.lihl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentService {
	/**
	 * 正常访问
	 *
	 * @param id
	 * @return
	 */
	public String paymentInfo_OK(Integer id) {
		return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
	}

	/**
	 * 超时访问
	 *
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
	public String paymentInfo_TimeOut(Integer id) {
		//异常
//		int num=1/0;
		//超时
		int timeNumber = 3;
		try {
			// 暂停3秒钟
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
				"O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
	}

	public String paymentInfo_TimeOutHandler(Integer id) {
		return  "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
				"%>_<%~ ";
	}

	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")})//失败率达到多少后跳闸
	public String paymentCircuitBreaker(Integer id) {
		if (id<0){
			throw new RuntimeException("不能为负数");
		}

		return  "线程池:" + Thread.currentThread().getName() + " paymentCircuitBreaker,流水:" + IdUtil.simpleUUID() + "\t" +
				"O(∩_∩)O~";
	}

	public String paymentCircuitBreaker_fallback(Integer id) {
		return  "id不能为负，稍后重试，   %>_<%";
	}

}



