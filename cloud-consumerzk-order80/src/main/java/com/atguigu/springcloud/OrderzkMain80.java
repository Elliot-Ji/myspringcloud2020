package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Elliot Ji
 * @date 2020/3/11.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderzkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderzkMain80.class,args);
    }

}
