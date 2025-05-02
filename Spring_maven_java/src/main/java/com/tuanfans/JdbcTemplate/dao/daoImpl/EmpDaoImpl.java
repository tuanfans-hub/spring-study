package com.tuanfans.JdbcTemplate.dao.daoImpl;

import com.tuanfans.JdbcTemplate.dao.EmpDao;
import com.tuanfans.JdbcTemplate.pojo.Emp;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */

@Repository
public class EmpDaoImpl implements EmpDao {
    private JdbcTemplate jdbcTemplate;

    public EmpDaoImpl() {
    }

    @Autowired
    public EmpDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int getEmpCount() {
        String sql = "select count(*) from mySpring.emp";
        // queryForObject:
        // queryForObject(String sql, Class<T> requiredType)
        // sql:SQL语句
        // requiredType:SQL语句的返回值类型的字节码
        // return:T

        // queryForObject(String sql, Class<T> requiredType, Object... args)
        // sql:SQL语句
        // requiredType:SQL语句的返回值类型的字节码
        // args:SQL语句中的占位符参数
        // return:T
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        return count==null?0:count;
    }

    @Override
    public Emp findEmpByEmpNo(int empNo) {
        String sql = "select * from mySpring.Emp where empno = ?";
        // queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
        // sql:SQL语句
        // rowMapper:SQL语句的返回值类型的字节码
        // args:SQL语句中的占位符参数
        // return:Emp
        /*
        RowMapper<Emp> rowMapper = new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate").toLocalDate(),
                        rs.getDouble("sal"),
                        rs.getDouble("comm"),
                        rs.getInt("deptno")
                );
            }
        };
        return jdbcTemplate.queryForObject(sql, rowMapper, empNo);
         */

        //spring提供了更简单的方法
        BeanPropertyRowMapper<Emp> rowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,empNo);
    }

    @Override
    public List<Emp> findEmpByDeptNo(int deptNo) {
        String sql = "select * from mySpring.Emp where deptno = ?";
        // query(String sql, RowMapper<T> rowMapper, Object... args)
        // sql:SQL语句
        // rowMapper:SQL语句的返回值类型的字节码
        // args:SQL语句中的占位符参数
        // return:List<T>
        BeanPropertyRowMapper<Emp> rowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
        return jdbcTemplate.query(sql,rowMapper,deptNo);
    }

    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into mySpring.Emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)values(?,?,?,?,?,?,?,?)";
        // update(String sql, Object... args):增、删、改操作都是用该方法
        // sql:SQL语句
        // args:SQL语句中的占位符参数
        // return:int
        return jdbcTemplate.update(sql, emp.getEmpNo(),emp.getEname(), emp.getJob(), emp.getMgr(),
                emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno());
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update mySpring.Emp set ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? where empno = ?";
        return jdbcTemplate.update(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpNo());
    }

    @Override
    public int deleteEmp(int empNo) {
        String aql = "delete from mySpring.Emp where empno = ?";
        return jdbcTemplate.update(aql, empNo);
    }
}
