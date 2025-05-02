package com.tuanfans.service;

import com.tuanfans.dao.UserDao;
import com.tuanfans.dao.impl.UserDaoImpl;

/**
 * @author TuanFans
 * &#064;date 2025/4/9
 * &#064description
 */
public class UserService {
    private UserDao userDao;

    public UserService(){
    }

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public UserDao getUserDao(){
        return userDao;
    }

    public void getUser(){
        System.out.println("UserService.getUser()...");
        userDao.getUser();
    }
}
