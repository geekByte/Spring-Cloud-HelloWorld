package com.geekbyte.springcloud.controller;

import com.geekbyte.springcloud.entity.Dept;
import com.geekbyte.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供RESTful服务
@RestController  //使用这个注解会返回字符串
//@Controller   对应有前端页面的返回方式
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept queryById(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if(ObjectUtils.isEmpty(dept)) {
            throw new RuntimeException("id=>" + id + ",不存在该用户，或者信息没有找到~");
        }
        return dept;
    }

    //备选方法
    private Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptNo(id)
                .setName("id=>" + id + "，没有对应的信息～  @Hystrix")
                .setDbSource("No this data in MySQL");
    }
}
