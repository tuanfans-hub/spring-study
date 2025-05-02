package com.tuanfans.AOP.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author TuanFans
 * @date 2025/4/30
 * @description AOP配置类
 */
@Configuration
@ComponentScan("com.tuanfans.AOP")//扫描包
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启AOP,自动生成代理对象
public class AOPConfig {
}
