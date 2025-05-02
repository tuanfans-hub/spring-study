package com.tuanfans.JdbcTemplate.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description 员工实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Emp implements Serializable {
    //因为数据库数据可能为null,所以使用包装类，兼容null值
    private Integer EmpNo;
    private String ename;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
