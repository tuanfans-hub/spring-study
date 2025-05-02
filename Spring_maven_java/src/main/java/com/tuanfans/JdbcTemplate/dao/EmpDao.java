package com.tuanfans.JdbcTemplate.dao;

import com.tuanfans.JdbcTemplate.pojo.Emp;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
public interface EmpDao {
    /**
     * 获取员工数量
     * @return 员工数量
     */
    int getEmpCount();

    /**
     * 根据员工编号查询员工信息
     * @param empNo 员工编号
     * @return 员工信息
     */
    Emp findEmpByEmpNo(int empNo);

    /**
     * 根据部门编号查询员工信息
     * @param deptNo 部门编号
     * @return 员工信息
     */
    List<Emp> findEmpByDeptNo(int deptNo);

    /**
     * 添加员工
     * @param emp 员工信息
     * @return 添加员工数量
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号修改员工
     * @param emp 员工信息
     * @return 影响行数
     */
    int updateEmp(Emp emp);

    /**
     * 根据员工编号删除员工
     * @param empNo 员工编号
     * @return 影响行数
     */
    int deleteEmp(int empNo);

    /**
     * 接口中的默认方法
     */
    default void read(){
        System.out.println("default.EmpDao.read()...");
    }
}
