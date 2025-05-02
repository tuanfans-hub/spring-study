package com.tuanfans.factory;

import com.tuanfans.beans.Master;
import com.tuanfans.beans.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TuanFans
 * &#064;date 2025/4/13
 * &#064description 静态工厂类
 */
public class MyStaticFactory {
    private static Map<String, Monster> monsterMap;

    // 使用静态代码块初始化monsterMap
    static{
        monsterMap = new HashMap<>();
        monsterMap.put("monster1", new Monster(new Master(),1, "孙悟空", "七十二变"));
        monsterMap.put("monster2", new Monster(new Master(),2, "猪八戒", "能吃"));
        monsterMap.put("monster3", new Monster(new Master(),2, "沙和尚", "任劳任怨"));
    }

    public static Monster getMonster(String name){
        return monsterMap.get(name);
    }
}
