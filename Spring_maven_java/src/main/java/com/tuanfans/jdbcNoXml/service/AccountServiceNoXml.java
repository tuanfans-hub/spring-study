package com.tuanfans.jdbcNoXml.service;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface AccountServiceNoXml {
    int transMoney(Integer from,Integer to,Double money);
}
