package com.geekbyte.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   //@Configuration这个注解相当于Spring中的applicationContext.xml
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //IRule 接口
    /**
     * IRule接口的常用实现类
     * AvailabilityFilteringRule: 会先过滤掉跳闸或者访问故障的服务,对剩下的服务进行轮训
     * RetryRule: 会先按照轮训获取服务,如果服务获取失败,会在指定的时间内进行重试
     * RandomRule: 随机
     * RoundRobinRule: 轮训
     */

    @Bean
    @LoadBalanced  //开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    这个配置一般放在主启动类上,这样能从主启动类上体现Ribbon
//    参考:https://www.springcloud.cc/spring-cloud-dalston.html#spring-cloud-ribbon
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

}
