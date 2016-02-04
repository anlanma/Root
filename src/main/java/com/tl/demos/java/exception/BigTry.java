package com.tl.demos.java.exception;

/**
 * Created by tanglin on 2016/2/2.
 * 当代码中有需要锁等资源时，需要在finally中将其释放，以防异常发生
 * try-finally必须在方法签名处抛出异常
 */
public class BigTry {
    public static void main(String[] args) throws Exception {
        method();
    }

    public static void method() throws Exception {
        try {
            throwExp1();

            try {
                throwExp2();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }finally {
            //释放资源
            System.out.println("finally");
        }
    }
    public static void throwExp2() throws Exception{
        throw new Exception("2");
    }
    public static void throwExp1() throws Exception{
        throw new Exception("1");
    }

}
