package com.andyron.demo02;

/**
 * @author Andy Ron
 */
public class Client {
    public static void main(String[] args) {
        /*
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();
         */

        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.delete();

    }
}
