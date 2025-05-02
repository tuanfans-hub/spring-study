package com.tuanfans.AOP.dao.daoImpl;

import com.tuanfans.AOP.dao.CatDao;

/**
 * @author TuanFans
 * @date 2025/4/21
 * @description
 */

public class CatDaoImplByXml implements CatDao {
    private String name;

    public CatDaoImplByXml(){

    }

    public CatDaoImplByXml(String name){
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
        System.out.println("CatDaoImplByXml.getCat()...");
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
