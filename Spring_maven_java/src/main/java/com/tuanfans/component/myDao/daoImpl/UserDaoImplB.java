package com.tuanfans.component.myDao.daoImpl;

import com.tuanfans.component.myDao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * @date 2025/4/19
 * @description
 */
@Repository("userDaoB")
public class UserDaoImplB implements UserDao {
    //@Value("TuanFansB")
    @Value("${userDaoB_name}")
    private String name;

    public UserDaoImplB() {
        System.out.println("UserDaoImplB无参构造方法！");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void getUser() {
        System.out.println("UserDaoImplB.getUser()...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "UserDaoImplB{" +
                "name='" + name + '\'' +
                '}';
    }
}
