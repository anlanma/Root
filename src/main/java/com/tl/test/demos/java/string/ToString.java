package com.tl.test.demos.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
//        System.out.println(new ToString().toString());
//        System.out.println(set());
//        System.out.println(map());


    }
    public static Set<String> set(){
        Set<String> sets = new HashSet<String>();
        sets.add("a");
        sets.add("b");
        return sets;
    }
    public static Map<String,String> map(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","one");
        map.put("2","two");
        return map;
    }

}
