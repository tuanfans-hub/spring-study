import com.tuanfans.AOP.config.AOPConfig;
import com.tuanfans.AOP.dao.CatDao;
import com.tuanfans.AOP.dao.DogDao;
import com.tuanfans.AOP.dao.daoImpl.CatDaoImplByXml;
import com.tuanfans.AOP.service.CatService;
import com.tuanfans.AOP.service.DogService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuanFans
 * @date 2025/4/21
 * @description AOP测试
 */
public class AOPTest {
    @Test
    public void testAOP(){
        AbstractApplicationContext ioc =
                new ClassPathXmlApplicationContext("AOP/aopBean1.xml");
        CatService catService = ioc.getBean("catServiceImpl", CatService.class);
        System.out.println(catService);
        catService.getCat();
        System.out.println("------------------------------");

        DogService dogService = ioc.getBean("dogServiceImpl", DogService.class);
        System.out.println(dogService);
        dogService.getDog();
        System.out.println("------------------------------");
        //因为没有进行相关配置，所以没有对方法进行增强
        DogDao dogDao = ioc.getBean("dogDaoImpl", DogDao.class);
        System.out.println(dogDao);
        dogDao.getDog();

        System.out.println("------------------------------");
        DogService dogService_proxy = ioc.getBean(DogService.class);
        //如果被切面配置命中，spring容器通过getBean方法获取对象时，则会返回代理对象
        //代理对象是在程序的运行过程中动态生成的对象，而不是在xml配置文件中定义的bean对象。
        System.out.println(dogService_proxy.getClass().getSimpleName());//$Proxy29
        System.out.println(dogService_proxy);
        dogService_proxy.getDog();
        System.out.println("****");
        dogService_proxy.gainId(1);
        System.out.println("****");
        System.out.println("dog_age="+dogService_proxy.gainAge(5));
        //执行顺序：1.@Before 2.@Around_before 3.代理方法
        // 4.@AfterReturning/4.@AfterThrowing  5.@Around_after 6.@After

        ioc.close();
    }

    @Test
    public void testAOPConfig(){
        AbstractApplicationContext ioc = new AnnotationConfigApplicationContext(AOPConfig.class);
        DogService dogService = ioc.getBean(DogService.class);
        System.out.println(dogService);
        dogService.getDog();
        ioc.close();
    }

    @Test
    public void testAopByXml(){
        AbstractApplicationContext ioc =
                new ClassPathXmlApplicationContext("AOP/aopBeanByXml.xml");
        CatDao catDao = ioc.getBean("catDaoImplByXml",CatDao.class);
        System.out.println(catDao);
        catDao.getCat();
        ioc.close();
    }
}
