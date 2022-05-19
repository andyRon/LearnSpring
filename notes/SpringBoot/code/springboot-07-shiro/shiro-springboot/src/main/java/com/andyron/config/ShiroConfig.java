package com.andyron.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Andy Ron
 */
@Configuration
public class ShiroConfig {

    // 3 ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器
        /*
            anon：无需认知就可以访问
            authc：必须认证才能访问
            user：必须拥有 记住我 功能才能访问
            perms：拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 授权，正常情况下，没有授权会跳转到未授权页面
        filterMap.put("/user/add", "perms[user:add]");

//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");
        filterMap.put("/user/*", "authc");

        bean.setFilterChainDefinitionMap(filterMap);
        // 设置登录的请求
        bean.setLoginUrl("/toLogin");
        // 未授权页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    // 2 DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Userrealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 1 创建Realm对象，需要自定义
    @Bean
//    @Bean(name = "userRealm")  // 默认为方法名
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
