package com.andyron.config;

import com.andyron.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 被@Configuration配置的类本身也会被Spring容器托管，注册到容器中，因为它本来就是一个@Component；
 @Configuration代表这是一个配置了，类似之前xml配置文件
 */
@Configuration
@ComponentScan("com.andyron.pojo")
@Import(AndyConfig2.class)
public class AndyConfig {
    /*
    注册一个bean，就相当于一个bean标签
    这个方法的名字就相当于bean标签中的id
    这个方法的返回值就相当于bean标签中的class
     */
    @Bean
    public User getUser() {
        return new User();
    }
}
