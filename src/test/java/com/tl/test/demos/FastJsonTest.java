package com.tl.test.demos;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanglin on 2016/1/6.
 */
public class FastJsonTest {

    @Test
    public void testNullValue(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("k1","");
        map.put("k2",null);
        System.out.println(JSON.toJSONString(map));
    }
    @Test
    public void testObj(){
        CustomObj o = new CustomObj(1,"test",2);
        System.out.println(JSON.toJSONString(o));
    }

    class CustomObj{
        private int i;
        private String s;
        private Integer integer;

        public CustomObj(int i,String s,Integer integer){
            this.i = i;
            this.s = s;
            this.integer = integer;
        }
    }
}
