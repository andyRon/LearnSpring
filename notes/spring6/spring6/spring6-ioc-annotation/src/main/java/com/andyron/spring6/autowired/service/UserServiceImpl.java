package com.andyron.spring6.autowired.service;

import com.andyron.spring6.autowired.dao.UserDao;
import com.andyron.spring6.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author andyron
 **/
@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    private UserDao userDao;

    // 第六种方式：两个注解，根据名称注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service.....");
        userDao.add();
    }

}
