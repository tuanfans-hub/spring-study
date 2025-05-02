import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/10
 * &#064description
 */
public class Dom4jTest {
    @Test
    public void testLoadXML(){
        // 得到一个解析器
        SAXReader reader = new SAXReader();
        // 解析xml文件
        Document document = null;
        try {
            InputStream ras = getClass().getClassLoader().getResourceAsStream("xmlBeans/dom4j.xml");
            document = reader.read(ras);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("document="+document);
        System.out.println("-----------------------");
        // 获取根元素
        Element root = null;
        if (document != null) {
            root = document.getRootElement();
        }
        System.out.println("root="+root.asXML());
        // 遍历根节点的所有子节点
        System.out.println("--------遍历根节点的所有子节点--------");
        // 方法1：遍历根节点的所有子节点
        for (Element element : root.elements()) {
            System.out.println("element="+element.asXML());
        }
        // 方法2：遍历根节点的相同子节点
        System.out.println("--------遍历根节点的相同子节点-------");
        List<Element> students = root.elements("student");
        for(Element student:students){
            System.out.println("student="+student.asXML());
        }
        // 获取student节点的子标签的内容
        System.out.println("----------获取student节点的子元素----------");
        for(Element element : root.elements()){
            Element name = element.element("name");
            Element age = element.element("age");
            System.out.println("name="+name.getText()+" age="+age.getText());
        }
        // 获取student节点的属性
        System.out.println("----------获取student节点的属性----------");
        List<Element> stus = root.elements("student");
        for(Element stu : stus){
            String id = stu.attributeValue("id");
            System.out.println("name="+id);
        }

    }
}
