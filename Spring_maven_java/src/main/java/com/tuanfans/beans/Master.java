package com.tuanfans.beans;

import org.springframework.core.convert.Property;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author TuanFans
 * &#064;date 2025/4/13
 * &#064description
 */
public class Master {
    private String name;
    private List<Monster> monsterList;
    private Map<String,Monster> monsterMap;
    private Set<Monster> monsterSet;

    private String[] monsterName;

    private Properties props;

    public Master() {
    }

    public Master(List<Monster> monsterList, Map<String, Monster> monsterMap, String[] monsterName, Set<Monster> monsterSet, String name, Properties props) {
        this.monsterList = monsterList;
        this.monsterMap = monsterMap;
        this.monsterName = monsterName;
        this.monsterSet = monsterSet;
        this.name = name;
        this.props = props;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public Map<String, Monster> getMonsterMap() {
        return monsterMap;
    }

    public void setMonsterMap(Map<String, Monster> monsterMap) {
        this.monsterMap = monsterMap;
    }

    public String[] getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String[] monsterName) {
        this.monsterName = monsterName;
    }

    public Set<Monster> getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(Set<Monster> monsterSet) {
        this.monsterSet = monsterSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void getMonster() {
        System.out.print("我是"+name+"，我养了这么多妖怪：");
        for (String s : monsterName) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
