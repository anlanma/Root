package com.tl.test.demos.java.array;

/**
 * Created by tanglin on 2016/1/26.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] array = {"a","b","c"};
        System.out.println("Befor modify:");
        print(array);
        //����ͨ�������޸�����
        modify(array);
        System.out.println("After modify:");
        print(array);

        String[] array2 = {"A","B","C"};
        //���������õĿ�����Ч
        swap(array,array2);
        print(array);
        print(array2);


        int a = 1,b = 2;
        //������ֵ�Ŀ�����Ч
        swap(1,2);
        System.out.println("a:"+a+" b:"+b);


    }

    public static void print(String[] array){
        for(String s : array){
            System.out.print(s + " ");
        }
    }

    /**
     * �������a,bֵ�Ŀ����������ڲ���������Ӱ���ⲿ��ֵ
     * @param a
     * @param b
     */
    public static void swap(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    /**
     * ��������������õĿ���
     * ��ֻ�ǻ��ཻ�������κθ�����
     * ֻ�иı���������ָ��Ķ�������ݣ��Żᵼ�º���������ı䣬��Ϊ���Ƕ�ָ��ͬһ������
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
