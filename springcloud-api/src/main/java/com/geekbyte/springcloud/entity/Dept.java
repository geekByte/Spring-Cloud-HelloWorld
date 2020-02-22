package com.geekbyte.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor   //无参构造器
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable { //实体类务必实现序列化，否则传输可能出现错误

    private long deptNo;
    private String name;

    //数据来源，因为同一个信息可能存在不同的数据库
    private String dbSource;

    public Dept(String name) {
        this.name = name;
    }

    /**
     * 链式写法：
     *  Dept dept = new Dept();
     *  dept.setDeptNo(11).setName("abc").setDbSource("001"); //可以连续通过'.'去赋值
     */
}
