package com.geekbyte.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 访问链接：http://www.geekbyte.com:9527/springcloud-provider-dept/dept/get/1
 * springcloud-provider-dept要用小写
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableZuulProxy
public class ZullApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZullApplication_9527.class, args);
    }
}
