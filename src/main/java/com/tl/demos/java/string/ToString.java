package com.tl.demos.java.string;

/**
 * Created by tanglin on 16/2/16.
 */
public class ToString {
    private String prefix = null;
    private String content = "/test";

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder("");
//        if(prefix != null){
//            sb.append(prefix);
//        }
//        if(content != null){
//            sb.append(content);
//        }
//        return sb.toString();
        return prefix + content;
    }

    public static void main(String[] args) {
        System.out.println(new ToString().toString());
    }
}
