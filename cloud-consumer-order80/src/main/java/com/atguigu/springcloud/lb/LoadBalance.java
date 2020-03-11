package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Elliot Ji
 * @date 2020/3/11.
 */
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
