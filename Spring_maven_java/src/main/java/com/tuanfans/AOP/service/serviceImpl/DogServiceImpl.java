package com.tuanfans.AOP.service.serviceImpl;

import com.tuanfans.AOP.dao.DogDao;
import com.tuanfans.AOP.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TuanFans
 * @date 2025/4/29
 * @description
 */
@Service
public class DogServiceImpl implements DogService {
    private DogDao dogDao;

    public DogServiceImpl(){

    }

    @Autowired
    public DogServiceImpl(DogDao dogDao){
        this.dogDao = dogDao;
    }

    public DogDao getDogDao() {
        return dogDao;
    }

    public void setDogDao(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    @Override
    public void getDog() {
        dogDao.getDog();
    }

    @Override
    public void gainId(int id) {
        dogDao.gainId(id);
    }

    @Override
    public int gainAge(int age) {
        return dogDao.gainAge(age);
        //return dogDao.gainAge(age)/0;//异常通知测试
    }

    @Override
    public String toString() {
        return "DogServiceImpl{" +
                "dogDao=" + dogDao +
                '}';
    }
}
