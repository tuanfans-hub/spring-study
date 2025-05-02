import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author TuanFans
 * @date 2025/4/20
 * @description 动态代理模式
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Dinner student = new Student("小明同学");
        Dinner teacher = new Teacher("大和老师");
        Life teacher2 = new Teacher("小和老师");

        // 获取类加载器
        ClassLoader classLoader = student.getClass().getClassLoader();
        // 获取实现的所有接口
        Class<?>[] interfaces = student.getClass().getInterfaces();
        // 获取代理处理器对象
        InvocationHandler handler = new MyInvocationHandler(student);
        Dinner studentProxy = (Dinner) Proxy.newProxyInstance(classLoader,interfaces,handler);
        studentProxy.eat("肉末茄子煲仔饭");

        System.out.println("-----------------------------------");
        ClassLoader classLoader2 = teacher2.getClass().getClassLoader();
        Class<?>[] interfaces2 = teacher2.getClass().getInterfaces();
        InvocationHandler handler2 = new MyInvocationHandler(teacher2);
        Life teacherProxy2 = (Life) Proxy.newProxyInstance(classLoader2,interfaces2,handler2);
        teacherProxy2.eat("煲仔饭");
        teacherProxy2.takeShower();
        int addResult = teacherProxy2.add(100,100);
        System.out.println("a + b = "+addResult);

    }
}

// 定义接口
interface Life extends Dinner, Shower{
    int add(int a,int b);
}

interface Dinner{
    void eat(String food);
}

interface Shower{
    void takeShower();
}

// 定义实现类
class Student implements Dinner{
    private String name;

    public Student(String name){
        this.name = name;
    }
    @Override
    public void eat(String food) {
        System.out.println(name+"正在学生食堂吃" + food);
    }
}

class Teacher implements Life{
    private final String name;

    public Teacher(String name){
        this.name = name;
    }
    @Override
    public void eat(String food) {
        System.out.println(name+"正在老师食堂吃" + food);
    }

    @Override
    public void takeShower() {
        System.out.println(name+"正在洗澡...");
    }

    @Override
    public int add(int a, int b) {
        System.out.println("正在计算a+b...");
        return a+b;
    }
}

// 创建代理处理器
class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    // 代理方法:当调用代理对象的任何方法时，实际调用的是invoke方法

    /**
     *
     * @param proxy 代理对象
     * @param method 被代理的方法
     * @param args 被代理方法方法的参数
     * @return 被代理方法执行后的返回值
     * @throws Throwable 如果代理方法执行过程中抛出异常，则将异常抛出
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(method.getName().equals("eat")){
            // 如果方法名是eat，则执行：
            System.out.println("-----吃饭-----");
            System.out.println("吃饭之前行为：洗手、拿碗筷、打饭...");
            result = method.invoke(target, args);
            System.out.println("吃饭之后行为：洗碗、洗澡...");
        }else if(method.getName().equals("takeShower")){
            // 如果方法名是takeShower，则执行：
            System.out.println("-----洗澡-----");
            System.out.println("洗澡之前行为：拿衣服、换拖鞋...");
            result = method.invoke(target, args);
            System.out.println("洗澡之后行为：穿衣服、洗衣服、睡觉...");
        }else{
            System.out.println("-----计算-----");
            System.out.println("获取加数a="+args[0]+",被加数b="+args[1]);
            result = method.invoke(target, args);
            System.out.println("加法之后行为：打印结果:"+result);
        }
        return result;
    }
}