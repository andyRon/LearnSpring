package com.andyron.springcloud.config;

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


}
