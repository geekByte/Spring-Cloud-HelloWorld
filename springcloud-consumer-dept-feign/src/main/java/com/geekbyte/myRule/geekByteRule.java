package com.geekbyte.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class geekByteRule {

//    @Bean
//    public IRule geekbyteRule() {
//        return new geekByteRandomRule();
//    }

    //测试Hystrix负载均衡，上面自己实现的方法有个bug,所以使用原先的随机规则
    @Bean
    public IRule geekbyteRule() {
        return new RandomRule();
    }
}
