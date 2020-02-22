//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by geekbyte)
//

package com.geekbyte.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
public class geekByteRandomRule extends AbstractLoadBalancerRule {

    /**
     * 实现对每个服务调用5次后切换别的服务
     */

    private int total = 0;  //调用当前服务的次数
    private int currentIndex = 0;  //当前服务


    public geekByteRandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                if(total < 5) {
                    server = (Server)upList.get(currentIndex);
                    total += 1;
                } else {
                    total = 0;
                    currentIndex += 1;
                    if(currentIndex >= serverCount) {
                        currentIndex = 0;
                    }
                    server = (Server)upList.get(currentIndex);
                }
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
