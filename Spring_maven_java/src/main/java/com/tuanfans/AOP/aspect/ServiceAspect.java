package com.tuanfans.AOP.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author TuanFans
 * @date 2025/4/29
 * @description 切面类：用于定义切面，切面类中定义切面方法，切面方法中定义切面规则。
 */
@Component
@Aspect
@Order(2)//切面类的优先级，值越小，优先级越高
public class ServiceAspect {
    //切点表达式：execution(方法权限类型 返回值类型 包名.类名.方法名(参数列表))
    //切点表达式中，*表示匹配任意字符，..表示匹配任意个字符

    //前置通知@Before("切点表达式")
    //前置通知，在切入点方法执行前执行
    @Before("execution(* com.tuanfans.AOP.service.*.get*(..))")
    public void before(){
        System.out.println("ServiceAspect.before() invoke...");
    }

    @Before("execution(* com.tuanfans.AOP.service.*.gainId(..))")
    public void gainBefore(JoinPoint joinpoint){
        System.out.println("gainBefore invoke...");
        Object[] args = joinpoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("dog_id="+args[0]);
    }

    //@Pointcut: 定义切点
    //切点表达式中，..表示匹配任意个字符，*表示匹配任意字符，?表示匹配一个字符
    //如果切面类中的多个方法都需要使用同一个切点表达式，可以定义一个切点方法，然后在多个方法中引用该切点方法。
    @Pointcut("execution(* com.tuanfans.AOP.service.*.gainAge(..))")
    public void gainAgePointcut(){}

    //后置通知@After("切点表达式")
    //后置通知，在切入点方法执行后执行
    //无论切点方法正常执行或者异常退出，都会执行
    @After("gainAgePointcut()")
    public void gainAgeAfter(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        Integer age = (Integer)args[0];
        System.out.println("gainAgeAfter invoke...");
        System.out.println("After-明年dog的年龄为："+(age+1));
    }

    //返回通知@AfterReturning("切点表达式")
    //返回通知，在切入点方法正常返回结果（执行return语句）后执行；方法异常退出时不执行
    //可以接受切入点方法返回的结果
    @AfterReturning(value="gainAgePointcut()",
            returning="age")
    public void gainAgeAfterReturning(int age){
        System.out.println("gainAgeAfterReturning invoke...");
        System.out.println("AfterReturning-明年dog的年龄为："+(age+1));
    }

    //异常通知@AfterThrowing("切点表达式")
    //异常通知，在切入点方法异常退出时执行
    //可以接受切点方法抛出的异常
    @AfterThrowing(value="gainAgePointcut()",
            throwing="e")
    public void gainAgeAfterThrowing(Exception e){
        System.out.println("gainAgeAfterThrowing invoke...");
        System.out.println("异常信息为："+e.getMessage());
    }

    //环绕通知@Around("切点表达式")
    //环绕通知，在切入点方法执行前和切入方法返回结果后执行（相当于@Before和@AfterReturning）
    //环绕通知可以控制切入点方法的执行，可以接受切入点方法的参数，可以返回切入点方法的结果
    //参数pj表示切点方法对象，控制切入点方法的执行
    //环绕通知的返回值就是切入点方法的返回值，必须要将返回值向上返回
    @Around("gainAgePointcut()")
    public Object gainAgeRound(ProceedingJoinPoint pj){
        System.err.println("gainAgeRound invoke...Before!");//为了方便识别，使用错误输出流
        Object age = null;
        try {
            age = pj.proceed();//切点方法在这里执行！返回值为Object类型
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.err.println("gainAgeRound invoke...After!");
        return age;
    }
}
