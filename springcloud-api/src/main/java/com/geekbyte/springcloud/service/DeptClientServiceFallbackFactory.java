package com.geekbyte.springcloud.service;

import com.geekbyte.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //方法容器中
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setName("id=>" + id + ",不能再")
                        .setName("已经进行服务降级，暂时关闭服务")
                        .setDbSource("No Data");
            }

            @Override
            public List<Dept> queryAll() {
                List<Dept> list = new ArrayList<Dept>();
                list.add(new Dept()
                        .setName("已经进行服务降级，暂时关闭服务")
                        .setDbSource("No Data"));
                return list;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
