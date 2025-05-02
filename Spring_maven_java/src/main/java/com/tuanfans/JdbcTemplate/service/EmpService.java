package com.tuanfans.JdbcTemplate.service;

import com.tuanfans.JdbcTemplate.pojo.Emp;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface EmpService {
    int getEmpCount();

    Emp findEmpByEmpNo(int empNo);

    List<Emp> findEmpByDeptNo(int deptNo);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empNo);

    void read();
}
