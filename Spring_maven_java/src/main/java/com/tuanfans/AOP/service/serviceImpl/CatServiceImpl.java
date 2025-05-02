package com.tuanfans.AOP.service.serviceImpl;

import com.tuanfans.AOP.dao.CatDao;
import com.tuanfans.AOP.service.CatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author TuanFans
 * @date 2025/4/21
 * @description
 */
@Service
public class CatServiceImpl implements CatService {
    private final CatDao catDao;

    public CatServiceImpl(@Qualifier("catDaoImpl") CatDao catDao) {
        this.catDao = catDao;
    }
    @Override
    public void getCat(){
//        System.out.println("CatServiceImpl.getCat()...");
//        System.out.println("this:"+this.hashCode()+",catDao:"+catDao.hashCode());
//        System.out.println(this);
        catDao.getCat();
    }

    @Override
    public String toString() {
        return "CatServiceImpl{" +
                "catDao=" + catDao +
                '}';
    }
}
