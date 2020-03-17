package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Elliot Ji
 * @date 2020/3/9.
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("####### 插入结果"+result);

        if(result > 0){
            return new CommonResult(200,"插入数据成功,server: " + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("####### 插入结果"+payment);

        if(payment != null){
            return new CommonResult(200,"获取数据成功,serverposr: " + serverPort,payment);
        }else{
            return new CommonResult(444,"获取数据失败"+id,null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> instances = discoveryClient.getServices();
        for (String instance : instances ) {
           log.info("##########"+instance);
        }

        List<ServiceInstance> i = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : i) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    /**
     * 测试自定义的轮询算法
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return " O(∩_∩)O哈哈~,hi, zipkin...";
    }

}
