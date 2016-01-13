package com.tl.demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tanglin on 2015/12/22.
 */
public class SortTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("a-1.0.0-SNAPSHOT.tar.gz");
        names.add("a-1.0.0.tar.gz");
        names.add("a-1.0.1.tar.gz");

        Collections.sort(names);
//        Collections.reverse(names);
        for(String name : names){
            System.out.println(name);
        }
    }
}
