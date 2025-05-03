import com.tuanfans.action.UserServiceAction;
import com.tuanfans.beans.*;
import com.tuanfans.beans.Student;
import com.tuanfans.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuanFans
 * &#064;date 2025/4/12
 * &#064description
 */
public class BeansTest {
    @Test
    public void testBeansByConstructor(){
        // 当时用构造器配置bean时，创建ClassPathXmlApplicationContext对象时，每加载一个bean对象都会执行对应构造方法；
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/beansByConstructor.xml");
        Monster monster1 = ac.getBean("monster1", Monster.class);
        System.out.println("monster1 = "+monster1);
        Monster monster2 = ac.getBean("monster2", Monster.class);
        System.out.println("monster2 = "+monster2);
    }

    @Test
    public void testNamespace(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/namespace.xml");
        Monster monster1 = ac.getBean("monster1", Monster.class);
        System.out.println(monster1);
    }

    @Test
    public void testRefBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/ref_Bean.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.getUser();
        System.out.println("---------------------------");
        UserService userService1 = ac.getBean("userService2", UserService.class);
        userService1.getUser();
    }

    @Test
    public void testListBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/ListBean.xml");
        Master master = ac.getBean("master", Master.class);
        System.out.println(master.getMonsterList());
        System.out.println(master.getMonsterMap());
        System.out.println(master.getMonsterSet());
        master.getMonster();
        System.out.println(master.getProps());
    }

    @Test
    public void testUtilList(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/utilList.xml");
        Master master = ac.getBean("master", Master.class);
        System.out.println(master.getMonsterList());
    }

    @Test
    public void testCascadeBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/cascadeBean.xml");
        Monster monster = ac.getBean("monster", Monster.class);
        Master master = ac.getBean("master", Master.class);
        System.out.println(monster);
        System.out.println(master+"-->"+master.getName());
    }

    @Test
    public void testFactory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/factory.xml");
        System.out.println("----------------静态工厂--------------");
        Monster monster1 = ac.getBean("staticFactory1", Monster.class);
        Monster monster2 = ac.getBean("staticFactory2", Monster.class);
        System.out.println(monster1);
        System.out.println(monster2);
        System.out.println("----------------实例工厂--------------");
        Monster monster3 = ac.getBean("myInstance1", Monster.class);
        System.out.println(monster3);
        Monster monster4 = ac.getBean("myInstance2", Monster.class);
        System.out.println(monster4);
        System.out.println(monster1 == monster4);// false
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("xmlBeans/factoryBean.xml");
        Monster monster1 = ac.getBean("factoryBean1", Monster.class);
        Monster monster2 = ac.getBean("factoryBean2", Monster.class);
        Monster monster3 = ac.getBean("factoryBean3", Monster.class);
        System.out.println(monster1);
        System.out.println(monster2);
        System.out.println(monster3);
        // parent属性测试
        System.out.println("----------------parent属性测试--------------");
        Monster monster4 = ac.getBean("factoryBean4", Monster.class);
        Monster monster5 = ac.getBean("factoryBean5", Monster.class);
        System.out.println(monster4);
        System.out.println(monster5);
        //抽象Bean测试
        System.out.println("----------------抽象Bean测试--------------");
        try{
            Monster parentBean = ac.getBean("parentBean", Monster.class);
        }catch(Exception e){
            System.out.println("抽象Bean无法实例化，不能创建对象哦！");
            e.printStackTrace();
        }
    }

    @Test
    public void testScopeBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/ScopeBean.xml");
        Student student1_1 = ioc.getBean("student1", Student.class);
        Student student1_2 = ioc.getBean("student1", Student.class);
        Student student2_1 = ioc.getBean("student2", Student.class);
        Student student2_2 = ioc.getBean("student2", Student.class);
        System.out.println(student1_1);
        System.out.println(student1_2);
        System.out.println(student2_1);
        System.out.println(student2_2);
        System.out.println("---------------------------");
        // 由于bean对象id=student1的scope=singleton，是单例，所以student1_1和student1_2是同一个对象
        System.out.println(student1_1 == student1_2);//true
        // 由于bean对象id=student2的scope=prototype，是多例，所以student2_1和student2_2不是同一个对象
        System.out.println(student2_1 == student2_2);//false
    }

    @Test
    public void testLC(){
        // 当使用配置文件创建bean对象时，创建ClassPathXmlApplicationContext对象时，
        // 每加载一个bean对象都会执行对应的init()和destroy()方法；
        ApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/lifeCycleOfBean.xml");
        System.out.println("-------------------------------");
        LC_Student student = ioc.getBean("student1", LC_Student.class);
        System.out.println(student);
        ((AbstractApplicationContext)ioc).close();// 关闭容器，执行destroy()方法
        try{
            LC_Student student1 = ioc.getBean("student1", LC_Student.class);
            System.out.println(student1);
        }catch(Exception e){
            System.out.println("spring容器已被关闭，无法获取student1对象");
            e.printStackTrace();
        }
    }

    @Test
    public void testBeanPostProcessor(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/beanPostProcessor.xml");
        System.out.println("-----------------------------------------");
        LC_Student student1 = ioc.getBean("student1", LC_Student.class);
        LC_Student student2 = ioc.getBean("student2", LC_Student.class);
        System.out.println(student1+" : "+student1.getName());
        System.out.println(student2+" : "+student2.getName());
        ((AbstractApplicationContext)ioc).close();
    }

    @Test
    public void testMyProperties(){
        AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/Myproperties.xml");
        Cat cat1 = ioc.getBean("cat1", Cat.class);
        Cat cat2 = ioc.getBean("cat2", Cat.class);
        Cat cat3 = ioc.getBean("cat3", Cat.class);
        System.out.println(cat1);
        //由于在.properties文件中，为Unicode编码格式，不支持中文，会出现乱码
        //所有如果在.properties文件中，有中文，则将中文转为Unicode编码格式
        //（工具网站：https://tool.chinaz.com/tools/unicode.aspx）
        System.out.println(cat2);
        System.out.println(cat3);
        ioc.close();
    }

    @Test
    public void testAutoBean(){
        AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/AutoBean.xml");
        UserServiceAction usa = ioc.getBean("userServiceAction", UserServiceAction.class);
        usa.getUser();
        ioc.close();
    }

    @Test
    public void testSpELBean(){
        AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/SpELBean.xml");
        SpELBean spELBean = ioc.getBean("spELBean", SpELBean.class);
        System.out.println(spELBean);
        ioc.close();
    }

    @Test
    public void testHWMonster(){
        AbstractApplicationContext ioc = new ClassPathXmlApplicationContext("xmlBeans/noIdBean.xml");
        Monster monster1 = ioc.getBean("com.tuanfans.beans.Monster#0", Monster.class);
        Monster monster2 = ioc.getBean("com.tuanfans.beans.Monster#1", Monster.class);
        Student student = ioc.getBean("com.tuanfans.beans.Student#0", Student.class);
        System.out.println(monster1);
        System.out.println(monster2);
        System.out.println(student);
        ioc.close();
    }
}
