package com.tuanfans.JdbcTemplate.service.serviceImpl;

import com.tuanfans.JdbcTemplate.dao.EmpDao;
import com.tuanfans.JdbcTemplate.pojo.Emp;
import com.tuanfans.JdbcTemplate.service.EmpService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@Service
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpServiceImpl(){

    }

    @Autowired
    public EmpServiceImpl(EmpDao empDao){
        this.empDao = empDao;
    }

    public void setEmpDao(EmpDao empDao){
        this.empDao = empDao;
    }

    public EmpDao getEmpDao(){
        return empDao;
    }
    @Override
    public int getEmpCount() {
        return empDao.getEmpCount();
    }

    @Override
    public Emp findEmpByEmpNo(int empNo) {
        return empDao.findEmpByEmpNo(empNo);
    }

    @Override
    public List<Emp> findEmpByDeptNo(int deptNo) {
        return empDao.findEmpByDeptNo(deptNo);
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int empNo) {
        return empDao.deleteEmp(empNo);
    }


    @Override
    public void read(){
        empDao.read();
    }
}
