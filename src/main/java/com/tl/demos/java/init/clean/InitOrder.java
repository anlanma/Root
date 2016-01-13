package com.tl.demos.java.init.clean;

/**
 * Created by tanglin on 2016/1/12.
 * 同一个类中：静态字段>静态代码块>非静态字段>构造函数
 * 若类中持有其他类的引用，在第一次使用到该类时会加载该类，并初始化静态字段、静态代码块，若使用方式是新建对象则还会执行构造函数，若
 * 是调用静态方法则不执行构造函数
 */
public class InitOrder {
//    private static Base base1 = new Base(0);
    private static int i = 1;
    static {
        System.out.println("InitOrder static block: i = "+i);
        i = 2;
    }
    private int j = 3;
    InitOrder(){
        System.out.println("InitOrder constructor: i = "+i);
        System.out.println("InitOrder constructor: j = "+j);
        j=i+2;
        System.out.println("InitOrder constructor: j = "+j);
//        Base base3 = new Base(0);
    }
    //未初始化，不会被加载
//    private static Base base2;


    public static void main(String[] args) {
        InitOrder initOrder = new InitOrder();
        System.out.println("---------------");
        Base.f();
    }

}

class Base{
    private static int m = -4;
    static {
        System.out.println("Base static block: m = "+m);
        m = -3;
        System.out.println("Base static block: m = "+m);
    }
    private int n = -2;
    Base(int x){
        System.out.println("Base constructor: m = "+m);
        System.out.println("Base constructor: n = "+n);
        n = m + 2;
        System.out.println("Base constructor: n = "+n);
        System.out.println("Base constructor: x = "+x);
    }
    public static void f(){
        System.out.println("Base f()");
    }

}
