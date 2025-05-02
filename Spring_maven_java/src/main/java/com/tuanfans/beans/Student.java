package com.tuanfans.beans;

/**
 * @author TuanFans
 * &#064;date 2025/4/12
 * &#064description
 */
public class Student {
    public String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
