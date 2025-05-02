package com.tuanfans.service;

import com.tuanfans.beans.LC_Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author TuanFans
 * &#064;date 2025/4/14
 * &#064description 后置处理器, 在bean初始化前后进行一些处理
 * 实现BeanPostProcessor接口，并重写两个方法
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在bean初始化之前进行一些处理
     * @param bean 在ioc容器中创建/配置的bean对象
     * @param beanName bean对象的id
     * @return Object 程序员对传入的bean进行修改或处理后的bean对象（如果需要的话）
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----------------------------------------");
        System.out.println("初始化之前:"+bean+";"+beanName);
        if(bean instanceof LC_Student lc_student){
            System.out.println(beanName+" : "+lc_student.getName());
            System.out.println("修改"+beanName+"的name属性...");
            lc_student.setName("TuanFans");
        }
        System.out.println("-----------------------------------------");
        return bean;
    }

    /**
     * 在bean初始化之后进行一些处理
     * @param bean 在ioc容器中创建/配置的bean对象
     * @param beanName bean对象的id
     * @return Object 程序员对传入的bean进行修改或处理后的bean对象（如果需要的话）
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----------------------------------------");
        System.out.println("初始化之后:"+bean+";"+beanName);
        if(bean instanceof LC_Student lc_student){
            System.out.println(beanName+" : "+lc_student.getName());
        }
        return bean;
    }
}
