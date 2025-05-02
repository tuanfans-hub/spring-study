package com.tuanfans.AOP.dao.daoImpl;

import com.tuanfans.AOP.dao.DogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * @date 2025/4/29
 * @description
 */
@Repository
public class DogDaoImpl implements DogDao {
    private String name;

    public DogDaoImpl(){

    }

    public DogDaoImpl(String name){
        this.name = name;
    }

    @Autowired
    public void setName(@Value("小汪")String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void getDog() {
        System.out.println("DogDaoImpl.getDog()...");
    }

    @Override
    public void gainId(int id) {
        System.out.println("DogDaoImpl.gainId()..."+id);
    }

    @Override
    public int gainAge(int age) {
        return age;
    }

    @Override
    public String toString() {
        return "DogDaoImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
