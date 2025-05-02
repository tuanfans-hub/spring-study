import com.tuanfans.beans.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuanFans
 * &#064;date 2025/4/9
 * &#064description
 */
public class MonsterTest {
    @Test
    public void testMonster(){
        // 1.创建容器ApplicationContext对象
        //  该容器与容器配置文件相关联
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/beans.xml");
        // 2.通过getBean方法获取容器中的对象
        //  getBean(String):默认返回对象的类型为Object，但运行类型是Monster
        Object monster = ac.getBean("monster1");
        System.out.println("monster："+monster+"\nmonster运行类型为："+monster.getClass());

        // 转成Monster类型之后，就可以调用Monster对象的方法了
        Monster monster1 = (Monster)ac.getBean("monster1");
        // 4.输出对象
        System.out.println("monster1："+monster1+"\nmonster1运行类型为："+monster1.getClass());
        System.out.println("获取monster1对象成功！");

        // 获取monster1对象时，除了可以强转为Monster类型之外，还可以在创建时就指定Class类型
        Monster monster1_2 = ac.getBean("monster1", Monster.class);
        System.out.println("monster1_2："+monster1_2);
        System.out.println("获取monster1_2对象成功！");

        // 5.查看容器中有那些bean对象
        String[] bns = ac.getBeanDefinitionNames();
        for (String bn : bns) {
            System.out.println(bn);
        }

        System.out.println(ac.isSingleton("monster1"));

    }

}
