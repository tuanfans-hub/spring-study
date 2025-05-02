package com.tuanfans.component.myService.serviceImpl;

import com.tuanfans.component.myDao.UserDao;
import com.tuanfans.component.myDao.daoImpl.UserDaoImplA;
import com.tuanfans.component.myService.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

/**
 * @author TuanFans
 * @date 2025/4/19
 * @description
 */
@Service("userService")
public class userServiceImpl implements UserService {
    // 不要创建对象，使用set方法注入的方式降低代码耦合度
    /*@Autowired：自动注入
    * 根据类型注入，如果只有一个有参构造方法，则不需要写@Autowired，因为Spring会默认注入
    * 如果有多个有参构造方法，则需要写@Autowired，因为Spring不知道使用哪个有参构造方法
    * 根据类型到容器中查找是否有对应的bean，然后给当前属性赋值；
    * 不依赖setter注入
    * 类型是接口，则根据类型到容器中查找所有该接口的实现类；
    * 当 @Autowired 匹配到多个相同类型的 bean 时，Spring 会抛出NoUniqueBeanDefinitionException 异常,
    * 解决方法见resources/notes/Spring笔记.txt
    *
    *
    */
    //    @Resource(name="userDaoB") // @Resource 注解根据名称注入
    @Autowired
    @Qualifier("userDaoA")//  @Qualifier 注解明确指定要注入的 bean 的名称
    private UserDao userDao;
    //@Value("TuanFans")// @Value 注解注入普通属性(基本数据类型及其包装类、String)
    @Value("${userServiceName}")// 通过配置文件获取属性值，EL 表达式
    private String name;

    // 使用注解装配bean，默认使用的是无参构造方法通过setter注入；
    // 只有当有参构造方法且没有无参构造方法时，才会使用有参构造方法注入：
    // -如果只有一个有参构造方法，则Spring容器默认使用该有参构造方法注入；
    // -如果存在多个有参构造方法，且没有一个有参构造方法被@Autowired注解所标记，则Spring容器会抛出异常；
    // -如果存在多个有参构造方法，且存在一个有参构造方法被@Autowired注解所标记，则Spring容器会优先使用该有参构造方法注入；
    // -如果存在多个有参构造方法，且存在多个有参构造方法被@Autowired注解所标记，则Spring容器会抛出异常；
    public userServiceImpl(){
        System.out.println("userServiceImpl无参构造方法！");
    }

    public userServiceImpl(UserDao userDao, String name){
        this.userDao = userDao;
        this.name = name;
    }
    /*
    public userServiceImpl(@Qualifier("userDaoA")UserDao userDao, @Value("TuanFans")String name){
        this.userDao = userDao;
        this.name = name;
    }
    只有没有无参构造方法时，才会使用有参构造方法的方式完成注入；
     */

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getUser() {
        System.out.println("userServiceImpl.getUser()...");
        System.out.println(this);
        userDao.getUser();
    }

    @Override
    public String toString() {
        return "userServiceImpl{" +
                "name='" + name + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
