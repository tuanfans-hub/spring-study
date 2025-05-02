package com.tuanfans.JdbcTemplate.service.serviceImpl;

import com.tuanfans.JdbcTemplate.dao.DeptDao;
import com.tuanfans.JdbcTemplate.pojo.Dept;
import com.tuanfans.JdbcTemplate.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    public DeptServiceImpl() {
    }

    @Autowired
    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public DeptDao getDeptDao() {
        return deptDao;
    }

    @Override
    public int[] batchAddDept(List<Dept> depts) {
        return deptDao.batchAddDept(depts);
    }

    @Override
    public int[] batchUpdateDept(List<Dept> depts) {
        return deptDao.batchUpdateDept(depts);
    }

    @Override
    public int[] batchDeleteDept(List<Integer> deptNos) {
        return deptDao.batchDeleteDept(deptNos);
    }
}
