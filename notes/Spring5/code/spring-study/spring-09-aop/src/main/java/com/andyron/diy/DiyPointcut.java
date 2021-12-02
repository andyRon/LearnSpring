package com.andyron.diy;

/**
 * @author Andy Ron
 */
public class DiyPointcut {

    public void before() {
        System.out.println("=======方法执行之前========");
    }

    public void after() {
        System.out.println("=======方法执行之后========");
    }
}
