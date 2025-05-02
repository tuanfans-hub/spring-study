package com.tuanfans.AOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author TuanFans
 * @date 2025/4/30
 * @description
 */
public class DaoAspectByXml {
    public void methodBefore(){
        System.out.println("DaoAspectByXml.methodBefore()...");
    }

    public void methodAfter(){
        System.out.println("DaoAspectByXml.methodAfter()...");
    }

    public void methodAfterThrowing(Exception e){
        System.out.println("DaoAspectByXml.methodAfterThrowing()...");
        System.out.println("异常信息为："+e.getMessage());
    }

    public void methodAfterReturning(Object o){
        System.out.println("DaoAspectByXml.methodAfterReturning()...");
        System.out.println("返回值为："+o);
    }

    public Object methodAround(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("DaoAspectByXml.methodAround()...Before");
        Object proceed = pj.proceed();
        System.out.println("DaoAspectByXml.methodAround()...After");
        return proceed;
    }
}
