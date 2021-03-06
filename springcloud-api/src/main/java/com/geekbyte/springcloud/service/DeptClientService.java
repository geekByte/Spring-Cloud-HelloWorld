package com.geekbyte.springcloud.service;

import com.geekbyte.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//本质上还是基于Ribbon,只是换了种理解方式

/**
 * 微服务名字   Feign
 *
 * 接口和注解   Ribbon
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
@RequestMapping("/dept")
public interface DeptClientService {

    @GetMapping("/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/list")
    public List<Dept> queryAll();

    @GetMapping("/add")
    public Boolean addDept(Dept dept);
}
