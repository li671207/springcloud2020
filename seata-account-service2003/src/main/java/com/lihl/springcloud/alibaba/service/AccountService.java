package com.lihl.springcloud.alibaba.service;

import java.math.BigDecimal;


public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
