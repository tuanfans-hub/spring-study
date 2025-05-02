package com.tuanfans.beans;

import java.io.File;

/**
 * @author TuanFans
 * &#064;date 2025/4/9
 * &#064description
 */
public class Monster {
    private Master master;
    private int id;
    private String name;
    private String skill;

    public Monster() {
    }

    public Monster(Master master,int id, String name, String skill) {
        this.master = master;
        this.id = id;
        this.name = name;
        this.skill = skill;
        System.out.println("有参构造器调用...");
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", master=" + master +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
