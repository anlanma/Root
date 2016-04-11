package com.tl.test.java.types;

import org.junit.Test;

/**
 * Created by tanglin on 16/4/11.
 */
public class TypeTest {

    @Test
    public void testBoolean(){
        //不支持由1,0转true,false
        Boolean bool = Boolean.valueOf("0");
        System.out.println(bool);
    }
}
