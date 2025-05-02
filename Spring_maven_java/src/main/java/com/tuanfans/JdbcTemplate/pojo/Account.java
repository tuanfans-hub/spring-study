package com.tuanfans.JdbcTemplate.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author TuanFans
 * @date 2025/5/1
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
