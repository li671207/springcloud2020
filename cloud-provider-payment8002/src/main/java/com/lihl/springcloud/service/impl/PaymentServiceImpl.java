package com.lihl.springcloud.service.impl;

import com.lihl.entities.Payment;
import com.lihl.springcloud.dao.PaymentDao;
import com.lihl.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Resource
	private PaymentDao paymentDao;


	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
