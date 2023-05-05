package com.andyron.service.impl;

import com.andyron.anno.Bean;
import com.andyron.anno.Di;
import com.andyron.dao.UserDao;
import com.andyron.service.UserService;

/**
 * @author andyron
 **/
@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("UserService...");
        userDao.add();
    }
}
