package com.geekbyte.springcloud.controller;

import com.geekbyte.springcloud.entity.Dept;
import com.geekbyte.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供RESTful服务
@RestController  //使用这个注解会返回字符串
//@Controller   对应有前端页面的返回方式
public class DeptController {

    @Autowired
    DeptService deptService;
    @Autowired
    //调用Spring Framework的包"import org.springframework.cloud.client.discovery.DiscoveryClient;"
    private DiscoveryClient client;

//    http://localhost:8001/dept/add?name="管理层"
//    @GetMapping("/dept/add")
    @RequestMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //注册进来的一些微服务,获取它的信息
    @GetMapping("/dept/discovery")
    public Object discover() {
        //获得服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discover => services" + services);

        //得到一个具体的微服务信息,通过具体的微服务id(applicationName)
        List<ServiceInstance> instanceList = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance : instanceList) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getInstanceId() + "\t" +
                    instance.getScheme() + "\t" +
                    instance.getServiceId() + "\t" +
                    instance.getMetadata() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri()
            );
        }
        return this.client;
    }

}
