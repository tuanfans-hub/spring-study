import com.tuanfans.component.config.SpringConfig;
import com.tuanfans.component.myController.UserAction;
import com.tuanfans.component.myComponent.MyComponent;
import com.tuanfans.component.myDao.UserDao;
import com.tuanfans.component.myService.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Vector;

/**
 * @author TuanFans
 * @date 2025/4/17
 * @description 注解测试
 */
public class AnnotationTest {
    @Test
    public void testFirstAnnotation(){
        AbstractApplicationContext ioc =
                new ClassPathXmlApplicationContext("annotationBeans/firstAnnotation.xml");
        UserDao userDao = ioc.getBean("userDaoA",UserDao.class);
        //UserService userService = ioc.getBean("userService",UserService.class);
        UserAction userAction = ioc.getBean("userAction",UserAction.class);
        MyComponent myComponent = ioc.getBean("myComponent",MyComponent.class);
        System.out.println(userDao);
        //System.out.println(userService);
        System.out.println(userAction);
        System.out.println(myComponent);
        ioc.close();
    }

    @Test
    public void testRename(){
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        // 对于引用数据类型，赋值时，只是复制了引用，所以修改其中一个，另一个也会改变。
        Vector<String> vector1 = vector;// 起别名，属于同一个对象。
        vector.add("4");
        System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector.hashCode());
        System.out.println(vector1.hashCode());
        System.out.println(vector == vector1);
        vector1 = null;
        System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector.hashCode());
        //System.out.println(vector1.hashCode());没有指向到任何对象，没有分配内存，所以无hashCode值。
        System.out.println(vector == vector1);
    }

    @Test
    public void testIocByAnnotation(){
        AbstractApplicationContext ioc =
                new ClassPathXmlApplicationContext("annotationBeans/iocByAnnotation1.xml");
        UserService userService = ioc.getBean("userService",UserService.class);
        userService.getUser();
        ioc.close();
    }

    @Test
    public void testSpringConfig(){
        // 通过SpringConfig.java配置类来创建IOC容器
        AbstractApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = ioc.getBean("userService", UserService.class);
        userService.getUser();
        ioc.close();
    }
}
