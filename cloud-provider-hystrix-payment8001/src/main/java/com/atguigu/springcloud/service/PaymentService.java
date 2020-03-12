package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Elliot Ji
 * @date 2020/3/12.
 */
@Service
public class PaymentService {

    /**
     * 代表正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_OK id: " +id +" O(∩_∩)O哈哈~";
    }

    /**
     * 假设处理业务
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
          commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
            //int age = 10/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut id: " +id +" O(∩_∩)O哈哈~"+"耗时3秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:  " + Thread.currentThread().getName() + "  系统出错,请稍后再试 id: " +id +" o(╥﹏╥)o";
    }
}
