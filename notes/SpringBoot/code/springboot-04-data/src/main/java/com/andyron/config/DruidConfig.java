package com.andyron.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy Ron
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource") // 绑定yaml文件对应属性
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控 相当于web.xml ServletRegistrationBean
    // 因为springboot内置了Servlet容器，所以没有web.xml，替代方法ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 意识就是访问"/druid/*"就会进入后台监控页面，如果没有将会出现 重定向的次数过多
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid" +
                "/*");

        // 后台需要有人访问，配置账号和密码
        HashMap<String, String> initParameters = new HashMap<>();
        // 添加配置
        initParameters.put("loginUsername", "admin"); // key是固定的 loginUsername loginPassword
        initParameters.put("loginPassword", "123456");
        // 允许谁访问
        initParameters.put("allow", "");
        // 禁止谁访问
//        initParameters.put()

        bean.setInitParameters(initParameters); // 设置初始化参数
        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean w() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        // 可以过滤那些请求呢？
        Map<String, String> initParameters = new HashMap<>();
        // 不统计的
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;

    }
}
