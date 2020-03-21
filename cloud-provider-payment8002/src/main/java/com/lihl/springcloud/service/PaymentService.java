package com.lihl.springcloud.service;

import com.lihl.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(@Param("id") Long id);
}
