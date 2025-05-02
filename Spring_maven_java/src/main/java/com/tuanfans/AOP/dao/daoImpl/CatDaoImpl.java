package com.tuanfans.AOP.dao.daoImpl;

import com.tuanfans.AOP.dao.CatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * @date 2025/4/21
 * @description
 */
@Repository
public class CatDaoImpl implements CatDao {
    private String name;

    public CatDaoImpl(){

    }

    @Autowired
    public CatDaoImpl(@Value("小橘")String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getCat() {
        System.out.println("CatDaoImpl.getCat()...");
//        System.out.println(this.hashCode());
//        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CatDaoImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
