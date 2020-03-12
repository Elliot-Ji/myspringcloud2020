package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Elliot Ji
 * @date 2020/3/12.
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }

}
