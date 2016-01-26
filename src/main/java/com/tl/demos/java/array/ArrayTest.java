package com.tl.demos.java.array;

/**
 * Created by tanglin on 2016/1/26.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] array = {"a","b","c"};
        System.out.println("Befor modify:");
        print(array);
        //可以通过引用修改内容
        modify(array);
        System.out.println("After modify:");
        print(array);

        String[] array2 = {"A","B","C"};
        //仅交换引用的拷贝无效
        swap(array,array2);
        print(array);
        print(array2);


        int a = 1,b = 2;
        //仅交换值的拷贝无效
        swap(1,2);
        System.out.println("a:"+a+" b:"+b);


    }

    public static void print(String[] array){
        for(String s : array){
            System.out.print(s + " ");
        }
    }

    /**
     * 传入的是a,b值的拷贝，函数内部交换并不影响外部的值
     * @param a
     * @param b
     */
    public static void swap(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    /**
     * 传入的是两个引用的拷贝
     * 若只是互相交换则无任何副作用
     * 只有改变了引用所指向的对象的内容，才会导致函数外变量改变，因为它们都指向同一个对象
     * @param a
     * @param b
     */
    public static void swap(String[] a,String[] b){
        String[] tmp = a;
        a = b;
        b = tmp;
    }
    public static void modify(String[] strs){
        strs[0] = "0";
        strs[1] = "1";
    }
}
