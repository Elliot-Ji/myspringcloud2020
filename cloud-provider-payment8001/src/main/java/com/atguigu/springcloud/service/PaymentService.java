package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Elliot Ji
 * @Date 2020/3/9
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
