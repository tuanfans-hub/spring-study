package com.tuanfans.beans;

/**
 * @author TuanFans
 * &#064;date 2025/4/15
 * &#064description
 */
public class SpELBean {
    private String name;
    private int age;
    private double weight;
    private Cat cat;
    private String catName;
    private String show;
    private String read;

    public SpELBean() {
    }

    public SpELBean(int age, Cat cat, String name, double weight,String catName,String show,String read) {
        this.age = age;
        this.cat = cat;
        this.name = name;
        this.weight = weight;
        this.catName = catName;
        this.show = show;
        this.read = read;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "SpELBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", cat=" + cat +
                ", catName='" + catName + '\'' +
                ", show='" + show + '\'' +
                ", read='" + read + '\'' +
                '}';
    }

    public String toShow(String name, String catName){
        return name+"非常喜欢"+catName;
    }

    public static String toRead(){
        return "正在阅读《三体》";
    }
}
