package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Elliot Ji
 * @date 2020/3/11.
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }

}
