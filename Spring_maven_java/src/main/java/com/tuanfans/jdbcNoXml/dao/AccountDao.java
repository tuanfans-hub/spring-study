package com.tuanfans.jdbcNoXml.dao;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */

public interface AccountDao {
    /**
     * 更新账户余额
     * @param id 账户id
     * @param money 更新金额
     * @param add 是否转入金额
     * <p>如果add为true，则转入金额，否则转出金额
     * @return 更新结果
     */
    int updateMoney(Integer id,Double money,Boolean add);

}
