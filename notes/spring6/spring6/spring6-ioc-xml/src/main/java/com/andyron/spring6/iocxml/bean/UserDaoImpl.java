package com.andyron.spring6.iocxml.bean;

/**
 * @author andyron
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("run...");
    }
}
