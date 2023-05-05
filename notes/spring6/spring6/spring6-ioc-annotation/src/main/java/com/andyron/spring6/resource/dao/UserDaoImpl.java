package com.andyron.spring6.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * @author andyron
 **/
@Repository("myUserDao")
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
