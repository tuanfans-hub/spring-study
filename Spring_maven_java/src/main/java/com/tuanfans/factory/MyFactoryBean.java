package com.tuanfans.factory;

import com.tuanfans.beans.Master;
import com.tuanfans.beans.Monster;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

/**
 * @author TuanFans
 * &#064;date 2025/4/13
 * &#064description MyFactoryBean实现FactoryBean接口
 */
public class MyFactoryBean implements FactoryBean<Monster> {
    private String key;

    private Map<String,Monster> monsterMap;

    {
        monsterMap = Map.of(
                "key1",new Monster(new Master(),1,"小型怪兽","普通攻击"),
                "key2",new Monster(new Master(),2,"中型怪兽","物理攻击"),
                "key3",new Monster(new Master(),3,"大型怪兽","精神攻击")
        );
    }

    public MyFactoryBean() {
    }

    public MyFactoryBean(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Monster getObject() throws Exception {
        return monsterMap.get(key);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
