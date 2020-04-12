package com.lihl.springcloud.alibaba.controller;


import com.lihl.springcloud.alibaba.domain.CommonResult;
import com.lihl.springcloud.alibaba.domain.Order;
import com.lihl.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);

        return new CommonResult(200, "订单创建完成");
    }
}
