package com.tuanfans.JdbcTemplate.dao.daoImpl;

import com.tuanfans.JdbcTemplate.dao.DeptDao;
import com.tuanfans.JdbcTemplate.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@Repository
public class DeptDaoImpl implements DeptDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DeptDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int[] batchAddDept(List<Dept> depts) {
        String sql = "insert into mySpring.dept (deptno,dname,loc) values(?,?,?)";
        // batchUpdate:批量更新：增、删、改操作都使用该方法
        // batchUpdate(String sql, List<Object[]> batchArgs)
        // sql:SQL语句
        // batchArgs:批量参数
        // return:int[]
        // 1.SUCCESS_NO_INFO：
        //      -2：表示成功插入数据
        //      1：表示修改数据成功
        // 2.EXECUTE_FAILED：
        //      -3：表示插入数据失败
        List<Object[]> args = new ArrayList<>();
        for (Dept dept : depts) {
            Object[] arg = {dept.getDeptno(),dept.getDname(),dept.getLoc()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    @Override
    public int[] batchUpdateDept(List<Dept> depts) {
        String sql = "update mySpring.dept set dname=?,loc=? where deptno=?";
        ArrayList<Object[]> args = new ArrayList<>();
        for(Dept dept: depts){
            Object[] arg = {dept.getDname(),dept.getLoc(),dept.getDeptno()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    @Override
    public int[] batchDeleteDept(List<Integer> deptNos) {
        String sql = "delete from mySpring.dept where deptno=?";
        List<Object[]> args = new ArrayList<>();
        for (Integer deptno : deptNos) {
            Object[] arg = {deptno};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}
