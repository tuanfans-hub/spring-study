package com.tuanfans.moreGetBean;

import com.tuanfans.beans.Monster;
import com.tuanfans.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuanFans
 * &#064;date 2025/4/12
 * &#064description HW_Monsters
 */
// 更具HW_Monsters.xml配置文件创建对象
public class T01_Monsters {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/noIdBean.xml");
        // 1.通过bean的id获取对象
        // 如果配置了id，则通过id获取对象
        // 如果没有配置id，则通过'类路径#编号'的格式获取对象；
        // 如果没有配置id，默认id = 类路径#编号；
        // 编号区别不同的对象；
        Object monster = ac.getBean("com.tuanfans.beans.Monster#0");
        Object student = ac.getBean("com.tuanfans.beans.Student#0");
        System.out.println(monster);
        System.out.println(student);
        // 2.通过bean的类型获取对象
        // 要求：在配置文件中，只能有一个bean的class属性与传入的参数的class属性相同；否则会有异常。
        Object monster1 = ac.getBean(Monster.class);
        Object student1 = ac.getBean(Student.class);
        System.out.println(monster1);
        System.out.println(student1);

    }
}
