package com.tuanfans.JdbcTemplate.dao.daoImpl;

import com.tuanfans.JdbcTemplate.dao.AccountDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@Repository
@Setter
@Getter
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    private final String addMoney = "update mySpring.account set money = money + ? where id = ?";
    private final String reduceMoney = "update mySpring.account set money = money - ? where id = ?";

    public AccountDaoImpl() {
    }

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int updateMoney(Integer id, Double money, Boolean add) {
        if(money<0){
            throw new RuntimeException("转账金额应大于0！");
        }
        if (add) {
            return jdbcTemplate.update(addMoney, money, id);
        } else {
            return jdbcTemplate.update(reduceMoney, money, id);
        }

    }


}
