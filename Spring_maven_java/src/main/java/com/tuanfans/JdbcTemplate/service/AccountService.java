package com.tuanfans.JdbcTemplate.service;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface AccountService {
    int transMoney(Integer from,Integer to,Double money);
}
