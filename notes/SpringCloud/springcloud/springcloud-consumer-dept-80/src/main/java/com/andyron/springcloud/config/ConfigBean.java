package com.andyron.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration 相当于spring中的 applicationContext.xml
 * @author Andy Ron
 */
@Configuration
public class ConfigBean {

    /**
     * RestTemplate默认没有@Bean，没有交给spring容器管理，需要在此配置一下
     * @LoadBalanced Ribbon负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 把默认的Ribbon负载均衡轮询方式，改为了随机。此时查询的数据就不是按固定顺序（db01、db02、db03）获取的，而是随机的。
     * IRule
     */
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }
}
