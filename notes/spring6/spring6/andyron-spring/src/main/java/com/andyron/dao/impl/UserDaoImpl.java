package com.andyron.dao.impl;

import com.andyron.anno.Bean;
import com.andyron.dao.UserDao;

/**
 * @author andyron
 **/
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDao....");
    }
}
