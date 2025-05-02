package com.tuanfans.SpringContainer_mini;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/10
 * &#064description 手写迷你版Spring容器-读取配置文件，并创建对象
 */
public class ClassPathXmlApplicationContext_mini implements ApplicationContext_mini{
    private Document config;

    private static String[] beanDefinitionNames_mini;

    public ClassPathXmlApplicationContext_mini(String config){
        // 读取配置文件,并初始化
        setConfig(config);
        setBeanDefinitionNames_mini();
    }

    private void setConfig(String config){
        SAXReader reader = new SAXReader();
        Document doc = null;
        try{
            InputStream is = ClassPathXmlApplicationContext_mini.class
                    .getClassLoader().getResourceAsStream(config);
            doc = reader.read(is);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.config = doc;
    }

    private Document getConfig(){
        return config;
    }
    @Override
    public Object getBean(String name) {
        Object o = null;
        try {
            o = getBean(name, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public <T>T getBean(String name, Class<T> clazz) {
        Class<?> beanClass = null;
        T instance = null;

        // 通过name找到对应的bean标签
        Element rootElement = config.getRootElement();
        Element bean = null;
        for(Element element : rootElement.elements("bean")){
            if(element.attributeValue("id").equals(name)){
                bean = element;
            }
        }
        // 通过bean标签中的class属性创建对象
        if (bean != null) {
            String beanClassPath = bean.attributeValue("class");
            try {
                beanClass = java.lang.Class.forName(beanClassPath);
                instance = clazz.cast(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 获取bean中的property标签中的属性值
        for(Element property : bean.elements("property")){
            String beanName = property.attributeValue("name");
            String beanName_value = property.attributeValue("value");
            // 通过反射得到对象的属性
            Field field = null;
            Object beanNameValue = null;
            try {
                field = beanClass.getDeclaredField(beanName);
                Class<?> fieldType = field.getType();
                // 将字符串类型数据转换成对应的基本数据类型数据
                // Class<?>.cast(value):无法实现基本数据类型的转换
                beanNameValue = stringToType(beanName_value, field.getType());
                // 强制反射：设置属性可访问性
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            // 通过反射给对象设置属性值
            try {
                field.set(instance,beanNameValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    // 将字符串类型数据转换成对应的基本数据类型数据
    private static Object stringToType(String value, Class<?> targetType) {
        if (targetType == Integer.class || targetType == int.class) {
            return Integer.parseInt(value);
        } else if (targetType == Double.class || targetType == double.class) {
            return Double.parseDouble(value);
        } else if (targetType == Float.class || targetType == float.class) {
            return Float.parseFloat(value);
        } else if (targetType == Long.class || targetType == long.class) {
            return Long.parseLong(value);
        } else if (targetType == Boolean.class || targetType == boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (targetType == String.class) {
            return value;
        } else {
            return targetType.cast(value);
        }
    }

    // 实现getBeanDefinitionNames()方法-获取所有bean的id
    public String[] getBeanDefinitionNames_mini(){
        return beanDefinitionNames_mini;
    }
    private void setBeanDefinitionNames_mini(){
        ArrayList<String> beanIds = new ArrayList<>();
        Element rootElement = config.getRootElement();
        List<Element> beans = rootElement.elements("bean");
        for (Element bean : beans) {
            String beanId = bean.attributeValue("id");
            beanIds.add(beanId);
        }
        String[] beanIdsArray = beanIds.toArray(new String[0]);
        beanDefinitionNames_mini = beanIdsArray;
    }
}
