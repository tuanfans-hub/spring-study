package com.tuanfans.component.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author TuanFans
 * @date 2025/4/20
 * @description Spring配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.tuanfans.component"})// 扫描包
@PropertySource("classpath:annotationBeans/my.properties")// 加载配置文件
public class SpringConfig {

}
