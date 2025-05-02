package com.tuanfans.SpringContainer_mini;

/**
 * @author TuanFans
 * &#064;date 2025/4/10
 * &#064description
 */
public interface BeanFactory_mini {
    /**
     * 根据beanName获取bean
     * @param name beanName
     * @return 返回对应的bean对象
     */
    Object getBean(String name);

    /**
     * 根据beanName获取bean并返回指定类型的bean对象
     * @param name beanName
     * @param clazz bean对象的类型
     * @return 返回指定类型的bean对象
     */
    <T>T getBean(String name, Class<T> clazz);
}
