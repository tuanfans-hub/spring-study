import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author TuanFans
 * @date 2025/4/20
 * @description Cglib代理模式
 */
public class CglibProxyTest {
    public static void main(String[] args){
        P tf = new P("TuanFans");
        // 创建代理对象
        //1.获得一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2.设置父类字节码
        enhancer.setSuperclass(P.class);
        //3.设置回调函数
        // 获取MethodInterceptor对象：实现MethodInterceptor接口，定义增强规则
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param obj 生成之后的代理对象——p_proxy
             * @param method 父类的方法--P.methods
             * @param args 方法的参数
             * @param proxy 代理对象生成的子类方法--p_proxy.methods
             * @return 方法的返回值
             * @throws Throwable 抛出异常
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                Object result = null;
                if(method.getName().equals("eat")){
                    System.out.println("-------------eat--------");
                    System.out.println("吃饭之前行为：洗手、准备碗筷...");
                    result = proxy.invokeSuper(obj, args);
                    System.out.println("吃饭之后行为：洗碗、阅读...");
                } else if(method.getName().equals("read")){
                    System.out.println("-------------read--------");
                    System.out.println("阅读之前行为：拿书...");
                    result = proxy.invokeSuper(obj,args);
                    System.out.println("阅读之后行为：总结、睡觉...");
                } else{
                    System.out.println("-------------add--------");
                    result = proxy.invokeSuper(obj,args);
                    System.out.println("add之前行为：a="+args[0]+" b="+args[1]);
                    System.out.println("add之后行为：打印结果："+result);
                }
                return result;
            }
        });
        //4.获取代理对象
        Class<?>[] argumentTypes = new Class[]{String.class};//构造器的参数类型
        Object[] arguments = new Object[]{"TuanFans"};//构造器的参数值
        P p_proxy = (P) enhancer.create(argumentTypes, arguments);
        //5.使用代理对象调用方法
        p_proxy.read("《Spring源码深度解析》");
        p_proxy.eat();
        p_proxy.add(1,2);
    }
}

class P{
    private String name;

    public P(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void read(String book){
        System.out.println(name+"正在阅读"+book+"...");
    }

    public void eat(){
        System.out.println(name+"正在吃饭...");
    }

    public int add(int a,int b){
        System.out.println(name+"正在计算a+b...");
        return a+b;
    }
}
