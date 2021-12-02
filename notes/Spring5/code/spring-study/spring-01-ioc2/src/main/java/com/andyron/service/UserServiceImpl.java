package com.andyron.service;

import com.andyron.dao.UserDao;

/**
 * @author Andy Ron
 */
public class UserServiceImpl implements UserService{

    /**
     * 把DAO引入Service里
     */
//    public UserDao userDao = new UserDaoOracleImpl();

    public  UserDao userDao;
    //利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
