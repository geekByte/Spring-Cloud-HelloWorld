package com.geekbyte.springcloud.controller;

import com.geekbyte.springcloud.Entity.Dept;
import com.geekbyte.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供RESTful服务
@RestController  //使用这个注解会返回字符串
//@Controller   对应有前端页面的返回方式
public class DeptController {

    @Autowired
    DeptService deptService;

//    http://localhost:8001/dept/add?name="管理层"
//    @GetMapping("/dept/add")
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> querAll() {
        return deptService.queryAll();
    }
}
