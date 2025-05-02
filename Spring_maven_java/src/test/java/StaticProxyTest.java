/**
 * @author TuanFans
 * @date 2025/4/20
 * @description 静态代理模式
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Person person = new Person("李四");
        Proxy proxy = new Proxy(person);
        proxy.doCourt();
    }
}

// 定义一个接口
interface Court{
    void doCourt();
}

// 定义一个实现类
class Person implements Court{
    private String name;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doCourt() {
        System.out.println(name+"提出申诉！表示没有犯罪！");
    }
}

// 定义一个代理类
class Proxy implements Court{
    private Person person;

    public Proxy(Person person){
        this.person = person;
    }
    @Override
    public void doCourt() {
        if(person==null){
            person = new Person("张三");
        }
        System.out.println("代理类调用doCourt()方法前行为！");
        // 调用实现类的方法
        person.doCourt();
        System.out.println("代理类调用doCourt()方法后行为！");
    }
}