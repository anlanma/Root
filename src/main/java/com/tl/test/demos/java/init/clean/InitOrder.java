package com.tl.test.demos.java.init.clean;

/**
 * Created by tanglin on 2016/1/12.
 * ͬһ�����У���̬�ֶ�>��̬�����>�Ǿ�̬�ֶ�>���캯��
 * �����г�������������ã��ڵ�һ��ʹ�õ�����ʱ����ظ��࣬����ʼ����̬�ֶΡ���̬����飬��ʹ�÷�ʽ���½������򻹻�ִ�й��캯����
 * �ǵ��þ�̬������ִ�й��캯��
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
    //δ��ʼ�������ᱻ����
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
