package com.andyron.spring6.iocxml.auto.dao;

/**
 * @author andyron
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public void addUserDao() {
        System.out.println("userDao方法执行了。。。");
    }
}
