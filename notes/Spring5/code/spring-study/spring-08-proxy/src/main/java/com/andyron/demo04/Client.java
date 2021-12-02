package com.andyron.demo04;

import com.andyron.demo02.UserService;
import com.andyron.demo02.UserServiceImpl;

/**
 * @author Andy Ron
 */
public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();

        // 代理角色，暂时不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 设置要处理的对象
        pih.setTarget(userService);
        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy();

        proxy.delete();
    }


}
