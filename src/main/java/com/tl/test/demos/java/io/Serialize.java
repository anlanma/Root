package com.tl.test.demos.java.io;

import java.io.*;

/**
 * Created by tanglin on 2016/2/2.
 */
public class Serialize implements Serializable{
    private static final String PATH = "src/main/java/com/tl/demos/java/io/person.txt";

    public static void main(String[] args) {
        //序列化和反序列化对应的类必须是同一个
        writeObject();
        readObject(PATH);
    }
    public static void writeObject(){
        House house = new House();
        house.setPrice(181.7f);
        house.setArea(89);

        //设置静态变量
        Person.testStatic = "test";
        Person p = new Person();
        p.setName("tl");
        p.setHouse(house);

        Person o = new Person();
        o.setName("jbb");
        ObjectOutputStream oos = null;
        try {
            //写入两个Person对象
            oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(p);
            oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void readObject(String path){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            Person p = (Person) ois.readObject();
            System.out.println(p);
            Person o = (Person) ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
class House implements Serializable{
    private float price;
    private float area;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                ", area=" + area +
                '}';
    }
}
class Person implements Serializable{
    private String name;
    //transient跳过指定变量
//    private transient House house;
    private House house;
    public static String testStatic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", house=" + house + ", testStatic=" + testStatic +
                '}';
    }
}

