package com.andyron.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * @author andyron
 **/
@Repository
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("User redis ....");
    }
}
