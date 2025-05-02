package com.tuanfans.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author TuanFans
 * @date 2025/4/30
 * @description
 */
@Component
@Aspect
@Order(1)
public class ServiceAspect2 {
    //如果两个切面方法都匹配到同一个方法，则先匹配到的切面方法先执行（两个切面的方法都会执行）
    //可通过@Order(number)指定优先级，number值越小，优先级越高
    //切点方法执行前的方法：@Order(number), number值越小，方法先执行
    //切点方法执行后的方法：@Order(number), number值越小，方法后执行
    @Before("execution(* com.tuanfans.AOP.service.*.get*(..))")
    public void getBefore(){
        System.out.println("ServiceAspect2.getBefore() invoke...");
    }
}
