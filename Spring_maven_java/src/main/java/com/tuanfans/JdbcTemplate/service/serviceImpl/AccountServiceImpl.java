package com.tuanfans.JdbcTemplate.service.serviceImpl;

import com.tuanfans.JdbcTemplate.dao.AccountDao;
import com.tuanfans.JdbcTemplate.pojo.Account;
import com.tuanfans.JdbcTemplate.service.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@Service
@Setter
@Getter
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl(){

    }

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    @Transactional
    public int transMoney(Integer from,Integer to, Double money) {
        // @Transactional注解：声明式事务管理：自动管理事务，不用写try-catch-finally
        // 该注解可以加在方法上，也可以加在类上；加在类上的话，所有方法都会加上事务管理
        int rows = 0;
        rows += accountDao.updateMoney(from,money,false);
        // 异常模拟
        //int i = 1/0;
        // 转入
        rows += accountDao.updateMoney(to,money,true);

        return rows;

        /*
        编程式事务管理：
        try{
            // 开启事务

            // 转出
            rows += accountDao.updateMoney(from,money,false);
            // 异常模拟
            int i = 1/0;
            // 转入
            rows += accountDao.updateMoney(to,money,true);
        }catch(Exception e){
            // 回滚
        }finally{
            // 提交
        }

         */

    }
}
