package com.andyron.spring6.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * @author andyron
 **/
@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("User redis ....");
    }
}
