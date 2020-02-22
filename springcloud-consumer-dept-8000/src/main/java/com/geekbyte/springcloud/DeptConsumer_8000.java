package com.geekbyte.springcloud;

import com.geekbyte.myRule.geekByteRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//Ribbon和Eureka整合以后,客户端可以直接调用,不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义的Ribbon配置
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = geekByteRule.class)
public class DeptConsumer_8000 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8000.class,args);
    }
}
