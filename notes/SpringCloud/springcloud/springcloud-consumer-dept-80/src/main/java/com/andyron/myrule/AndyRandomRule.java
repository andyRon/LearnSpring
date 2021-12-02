package com.andyron.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 模仿RandomRule，自定义负载均衡规则
 * 自定义规则：每个服务访问5次，换下一个服务
 */
public class AndyRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;      // 被调用的次数
    private int currentIndex = 0; // 当前谁在提供服务

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

                List<Server> upList = lb.getReachableServers();  // 获得活着的服务
                List<Server> allList = lb.getAllServers();  // 获得全部的服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);  // 生成区间随机数
//                server = (Server)upList.get(index);     // 从活着的服务，随机获取一个

               // 自定义算法规则==============<
                if (total < 5) {
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total = 0;
                    currentIndex++;
                    if (currentIndex >= upList.size()) {
                        currentIndex = 0;
                    }
                    server = upList.get(currentIndex);
                }
                // =====================>

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

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
