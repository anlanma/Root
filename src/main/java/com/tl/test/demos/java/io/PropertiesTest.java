package com.tl.test.demos.java.io;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tanglin on 2016/1/26.
 */
public class PropertiesTest {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            //绝对路径
//            in = new BufferedInputStream(new FileInputStream("E:\\GitHub\\Root\\src\\main\\resources\\conf.properties"));

            in = PropertiesTest.class.getClassLoader().getResourceAsStream("conf.properties");
            Properties p = new Properties();
            p.load(in);
            Map<String,String> map = new HashMap<String, String>((Map)p);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()){
                String key = (String) it.next();
                System.out.println("key:"+key+" value:"+map.get(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
