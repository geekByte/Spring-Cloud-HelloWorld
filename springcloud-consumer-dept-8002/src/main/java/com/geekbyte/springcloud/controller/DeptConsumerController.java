package com.geekbyte.springcloud.controller;

import com.geekbyte.springcloud.Entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解: 消费者不应该有Service层
    //Spring Boot支持RestFul风格请求

    //RestTemplate类有很多关于网络请求的方法,可以直接调用,在使用前,需要先将其注册到Spring中

    //Restful直接通过url去请求,不像RPC通过reference应用

    @Autowired
    private RestTemplate restTemplate;  //提供多种便捷访问远程http服务的方法,简单的Restful服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @PostMapping("/consumer/dept/add")
    public Boolean addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @GetMapping("/consumer/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

}
