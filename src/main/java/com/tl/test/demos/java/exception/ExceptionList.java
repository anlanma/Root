package com.tl.test.demos.java.exception;

/**
 * Created by tanglin on 16/2/28.
 */
public class ExceptionList {
    public static void main(String[] args) {
//        try {
            f();
//        } catch (MyException2 myException2) {
//            myException2.printStackTrace();
//        }
    }
    public static void g() throws MyException1 {
        throw new MyException1();

    }
    public static void f() {
        try {
            g();
        } catch (MyException1 myException1) {
            myException1.printStackTrace();
//            MyException2 exception2 = new MyException2();
            //若抛出runtime exception则方法头不需要声明，调用处不需要捕获
            RuntimeException exception2 = new RuntimeException();
            exception2.initCause(myException1);
            throw exception2;
        }
    }

    static class MyException1 extends Exception{
        public MyException1(){
            super("This is MyException1");
        }
    }

    static class MyException2 extends Exception{
        public MyException2(){
            super("This is MyException2");
        }
    }
}

