package com.tl.test.demos;

import org.junit.Test;

/**
 * Created by tanglin on 2015/12/24.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println(getVersion("a-b-1.0.1-SNAPSHOT.tar.gz"));
    }

    /**
     * @param jarName
     * @return
     */
    public static String getVersion(String jarName){
        if(jarName == null){
            return null;
        }

        int i = jarName.indexOf("-");
        int begin = jarName.indexOf("-", i+1);

        int end = jarName.indexOf(".tar.gz");
        if(end == -1){
            return null;
        }
        return jarName.substring(begin + 1,end);
    }
    @Test
    public void testSubString(){
        String str = "abcd";
        System.out.println(str.substring(0, str.length() - 1));
    }
}
