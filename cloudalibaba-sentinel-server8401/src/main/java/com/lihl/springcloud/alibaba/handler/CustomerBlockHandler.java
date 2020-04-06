package com.lihl.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihl.entities.CommonResult;


public class CustomerBlockHandler {

	public static CommonResult handlerException1(BlockException exception) {
		return new CommonResult(444, "CustomerBlockHandler----->自定义限流");
	}
}
