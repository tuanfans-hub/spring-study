import com.tuanfans.SpringContainer_mini.ClassPathXmlApplicationContext_mini;
import com.tuanfans.beans.Monster;
import org.junit.jupiter.api.Test;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description
 */
public class SpringContainerMiniTest {
    @Test
    public void testApplicationContext_mini(){
        ClassPathXmlApplicationContext_mini context = new ClassPathXmlApplicationContext_mini("xmlBeans/mini_SC_beans.xml");

        Object monster1 = context.getBean("monster1");
        //Monster monster1_1 = (Monster)context.getBean("monster1");
        System.out.println("monster1 = "+monster1);
        System.out.println("monster1_class = "+monster1.getClass());

        Monster monster1_1 = context.getBean("monster1", Monster.class);
        System.out.println("monster1_1 = "+monster1_1);
        System.out.println("monster1_1_class = "+monster1_1.getClass());

        // 获取所有bean的id属性
        String[] beanIds = context.getBeanDefinitionNames_mini();
        for (String beanId : beanIds) {
            System.out.print(beanId+" ");
        }
        System.out.println();
    }
}
