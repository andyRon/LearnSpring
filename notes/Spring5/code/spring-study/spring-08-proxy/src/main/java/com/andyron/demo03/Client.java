package com.andyron.demo03;

/**
 * @author Andy Ron
 */
public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();

        // 代理角色的生成
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);

        Rent proxy = (Rent) pih.getProxy(); // proxy就是动态生成的代理角色

        proxy.rent();
    }
}
