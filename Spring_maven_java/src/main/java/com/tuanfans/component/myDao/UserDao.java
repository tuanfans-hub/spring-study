package com.tuanfans.component.myDao;

import org.springframework.stereotype.Repository;

/**
 * @author TuanFans
 * &#064;date 2025/4/17
 * &#064description @Repository 注解用于标注数据访问组件，即DAO组件，属于持久化层
 */
@Repository("userDao")
public interface UserDao {
    void getUser();
}
