package com.andyron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 扩展springMVC  dispatcherservlet doDispatch
 *
 * @author Andy Ron
 */
@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    // 实现了ViewResolver接口的类，都可以把它看作视图解析器

    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    // 定义一个自己的视图解析器
    public static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
