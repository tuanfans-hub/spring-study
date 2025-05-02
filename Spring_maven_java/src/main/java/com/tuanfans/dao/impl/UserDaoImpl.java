package com.tuanfans.dao.impl;

import com.tuanfans.dao.UserDao;

/**
 * @author TuanFans
 * &#064;date 2025/4/9
 * &#064description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("UserDaoImpl.getUser(): I am a user");
    }
}
