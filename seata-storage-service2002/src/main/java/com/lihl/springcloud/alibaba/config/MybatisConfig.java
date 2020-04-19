package com.lihl.springcloud.alibaba.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lihl.springcloud.alibaba.dao"})
public class MybatisConfig {
}
