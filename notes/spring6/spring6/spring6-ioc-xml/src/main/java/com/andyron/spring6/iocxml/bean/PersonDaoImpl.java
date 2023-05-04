package com.andyron.spring6.iocxml.bean;

/**
 * @author andyron
 **/
public class PersonDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("person run ...");
    }
}
