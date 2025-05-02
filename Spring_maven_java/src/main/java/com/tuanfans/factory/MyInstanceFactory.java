package com.tuanfans.factory;

import com.tuanfans.beans.Master;
import com.tuanfans.beans.Monster;

import java.util.Map;

/**
 * @author TuanFans
 * &#064;date 2025/4/13
 * &#064description 实例工厂类
 */
public class MyInstanceFactory {
    private Map<String, Monster> monsterMap;

    {
        monsterMap = Map.of(
                "monster1", new Monster(new Master(),1, "孙悟空", "七十二变"),
                "monster2", new Monster(new Master(),2, "猪八戒", "吃"),
                "monster3", new Monster(new Master(),3, "沙和尚", "任劳任怨")
        );
    }

    public Monster getMonster(String name){
        return monsterMap.get(name);
    }
}
