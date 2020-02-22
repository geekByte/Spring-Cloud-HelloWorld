package com.geekbyte.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   //@Configuration这个注解相当于Spring中的applicationContext.xml
public class ConsumerConfig {

    //配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced  //Ribbon的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
