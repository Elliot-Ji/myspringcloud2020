package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Elliot Ji
 * @date 2020/3/12.
 */
@Component
public class PaymentServiceFallback implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentServiceFallback ------paymentInfo_OK o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentServiceFallback------paymentInfo_TimeOut--o(╥﹏╥)o";
    }
}
