package com.tuanfans.beans;

/**
 * @author TuanFans
 * &#064;date 2025/4/14
 * &#064description 生命周期-实体类
 */
public class LC_Student {
    private String name;

    public LC_Student() {
        System.out.println("调用了无参构造方法");
    }

    public LC_Student(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void init(){
        System.out.println("调用了init方法...");
    }

    public void destroy(){
        System.out.println("调用了destroy方法...");
    }

}
