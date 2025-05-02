package com.tuanfans.JdbcTemplate.dao;

import com.tuanfans.JdbcTemplate.pojo.Dept;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface DeptDao {
    /**
     * 批量添加部门信息
     * @param depts 部门信息
     * @return 结果信息
     */
    int[] batchAddDept(List<Dept> depts);

    /**
     * 批量修改部门信息
     * @param depts 部门信息
     * @return 结果信息
     */
    int[] batchUpdateDept(List<Dept> depts);

    /**
     * 批量删除部门信息
     * @param deptNos 部门编号
     * @return 结果信息
     */
    int[] batchDeleteDept(List<Integer> deptNos);
}
