package com.andyron.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * AOP方式比拦截器好很多
 *
 * @author Andy Ron
 */
@EnableWebSecurity // 开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 链式编程

    // 定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制授权请求的规则
        // 首页所有人可以访问，功能页只有对应有权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");


        // 开启自动配置的登录功能
        // /login 请求来到登录页
        // /login?error 重定向到这里表示登录失败
        // 没有权限默认到登录页面
        http.formLogin()
                .loginPage("/toLogin")// 定制登录页面loginPage，form的action就是"toLogin"
                .usernameParameter("user").passwordParameter("pwd")  // 用户名和密码的表单name不是默认的username和password时
                .loginProcessingUrl("/login")   // 登录认证页面，form的action是"/login"
        // 的action就改成这个
        ;

        // 开启注销功能，并返回首页
        http.logout().logoutSuccessUrl("/");

        // 暂时关掉csrf
        http.csrf().disable();  // 登出失败可能的原因

        // 开启记住我功能，Cookie，默认存两周
        http.rememberMe().rememberMeParameter("remember")  // 自定义接受前端的参数
        ;
    }
    /**
     * 定义认证规则
     *
     * 密码编码：PasswordEncoder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存中读取认证信息
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("andyron").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2", "VIP3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1");

        // 数据库中读取认证信息
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser()...
    }
}
