package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Elliot Ji
 * @date 2020/3/18.
 */
@RestController
public class OrderNacosController {
    @Value("${service-url.nacos-user-service}")
    private String server_URL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paytmentInfo(@PathVariable("id") Long id){
          return restTemplate.getForObject(server_URL+"/payment/nacos"+id,String.class);
    }

}
