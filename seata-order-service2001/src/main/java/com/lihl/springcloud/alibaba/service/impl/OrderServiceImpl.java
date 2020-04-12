package com.lihl.springcloud.alibaba.service.impl;

import com.lihl.springcloud.alibaba.dao.OrderDao;
import com.lihl.springcloud.alibaba.domain.Order;
import com.lihl.springcloud.alibaba.service.AccountService;
import com.lihl.springcloud.alibaba.service.OrderService;
import com.lihl.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    public void create(Order order) {
        log.info("******创建订单******");
        orderDao.create(order);
        log.info("******修改库存******");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("******扣减账户******");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("******修改订单状态******");
        orderDao.update(order.getUserId(), 0);

        log.info("******订单流程完成******");
    }
}
