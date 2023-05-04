package com.andyron.spring6.iocxml.auto.service;

import com.andyron.spring6.iocxml.auto.dao.UserDao;

/**
 * @author andyron
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行了。。。。");
        userDao.addUserDao();
    }
}
