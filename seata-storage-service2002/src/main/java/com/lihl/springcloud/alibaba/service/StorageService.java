package com.lihl.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;


public interface StorageService {

    void decrease(Long productId, Integer count);
}
