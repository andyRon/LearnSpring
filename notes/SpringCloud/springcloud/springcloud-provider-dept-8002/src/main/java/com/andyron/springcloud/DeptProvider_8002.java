package com.andyron.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * `@EnableEurekaClient` 表示服务启动后会自动注册到Eureka服务端中
 * @author Andy Ron
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 服务发现
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class, args);
    }
}
