package com.geekbyte.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class geekByteRule {

    @Bean
    public IRule geekbyteRule() {
        return new geekByteRandomRule();
    }
}
