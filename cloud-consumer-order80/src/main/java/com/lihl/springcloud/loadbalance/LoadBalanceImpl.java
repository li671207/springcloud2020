package com.lihl.springcloud.loadbalance;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@CommonsLog
public class LoadBalanceImpl implements LoadBalance {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	private final int getAndIncrement() {
		int current;
		int next;
		do {
			current = this.atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current + 1;
		} while (!this.atomicInteger.compareAndSet(current, next));
		log.info("next------>:   " + next);
		return next;

	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
		int index = getAndIncrement() % serviceInstances.size();

		return serviceInstances.get(index);
	}
}
