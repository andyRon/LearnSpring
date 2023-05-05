package com.andyron.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * @author andyron
 **/
@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
