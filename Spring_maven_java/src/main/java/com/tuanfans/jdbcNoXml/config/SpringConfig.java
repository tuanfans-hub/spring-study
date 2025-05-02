package com.tuanfans.jdbcNoXml.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author TuanFans
 * @date 2025/5/2
 * @description 配置类
 */
@Configuration // 配置类的标记注解
@ComponentScan(basePackages={
        "com.tuanfans.jdbcNoXml.dao",
        "com.tuanfans.jdbcNoXml.service"
}) //  扫描包
@PropertySource("classpath:JdbcTemplate/mysql.properties") // 导入配置文件
@EnableTransactionManagement // 开启事务注解
public class SpringConfig {
    @Value("${MySQL_DRIVER}")
    private String drive;
    @Value("${MySQL_USERNAME}")
    private String username;
    @Value("${MySQL_PASSWORD}")
    private String password;
    @Value("${MySQL_URL}")
    private String url;

    //配置数据源
    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(drive);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    // 配置JdbcTemplate
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    // 配置事务管理器
    @Bean
    public DataSourceTransactionManager getSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
