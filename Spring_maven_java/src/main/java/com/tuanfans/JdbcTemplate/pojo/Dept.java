package com.tuanfans.JdbcTemplate.pojo;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description 部门实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
}
