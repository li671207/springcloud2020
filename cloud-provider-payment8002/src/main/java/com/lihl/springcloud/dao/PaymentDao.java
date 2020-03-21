package com.lihl.springcloud.dao;

import com.lihl.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

	int create(Payment payment);

	Payment getPaymentById(@Param("id") Long id);
}
