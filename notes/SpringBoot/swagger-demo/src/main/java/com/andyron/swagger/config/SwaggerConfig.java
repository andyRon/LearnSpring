package com.andyron.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Andy Ron
 */
@Configuration
@EnableSwagger2     // 开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    // 配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        // 判断是否处于自己设置的环境中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("一个组名")
                // enable()：是否使用swagger
                .enable(flag)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                // basePackage()：指定要扫描的包
                // any()：扫描全部
                // none()：不扫描
                // withMethodAnnotation(GetMapping.class)：扫描有注解GetMapping的方法
                // withClassAnnotation(RestController.class)：扫描有注解RestController的类
                .apis(RequestHandlerSelectors.basePackage("com.andyron.swagger.controller"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                //paths() 过滤路径
//                .paths(PathSelectors.ant("/andy/**"))
                .build();
    }

    // 配置Swagger的信息
    public ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("AndyRon", "http://andyron.com", "rongming.2008@163.com");

        return new ApiInfo("AndyRon的Swagger API文档",
                "这是一个描述介绍",
                "v1.0",
                "http://andyron.com",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
