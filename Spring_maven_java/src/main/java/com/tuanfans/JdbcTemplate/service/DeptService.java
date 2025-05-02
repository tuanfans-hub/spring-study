package com.tuanfans.JdbcTemplate.service;

import com.tuanfans.JdbcTemplate.dao.DeptDao;
import com.tuanfans.JdbcTemplate.pojo.Dept;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface DeptService {
    int[] batchAddDept(List<Dept> depts);

    int[] batchUpdateDept(List<Dept> depts);

    int[] batchDeleteDept(List<Integer> deptNos);
}
