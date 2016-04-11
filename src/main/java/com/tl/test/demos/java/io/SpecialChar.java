package com.tl.test.demos.java.io;

/**
 * Created by tanglin on 2016/2/1.
 */
public class SpecialChar {
    public static void test(){
        String str = "| aaa |";

        String[] parts = str.split("\\|");
        System.out.println(parts.length);
        for(String part : parts){
            System.out.println(part == null);
            System.out.println(part.equals(""));
            System.out.println("part:"+part);
        }
    }
}
