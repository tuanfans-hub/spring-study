package com.tuanfans.component.myDao.daoImpl;

import com.tuanfans.component.myDao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * @date 2025/4/19
 * @description
 */
@Repository("userDaoA")
public class UserDaoImplA implements UserDao {
    //@Value("TuanFansA")
    @Value("${userDaoA_name}")
    private String name;

    public UserDaoImplA() {
        System.out.println("UserDaoImplA无参构造方法！");
    }

    public UserDaoImplA(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void getUser() {
        System.out.println("UserDaoImplA.getUser()...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "UserDaoImplA{" +
                "name='" + name + '\'' +
                '}';
    }
}
