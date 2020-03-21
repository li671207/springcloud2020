package com.lihl.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

	ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
