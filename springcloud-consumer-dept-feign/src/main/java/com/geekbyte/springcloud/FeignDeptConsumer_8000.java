package com.geekbyte.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

//Ribbon和Eureka整合以后,客户端可以直接调用,不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.geekbyte.springcloud"})
@ComponentScan("com.geekbyte.springcloud")
public class FeignDeptConsumer_8000 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_8000.class,args);
    }
}
