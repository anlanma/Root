package com.tl.demos;

/**
 * Created by tanglin on 2015/12/24.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println(getVersion("a-b-1.0.1-SNAPSHOT.tar.gz"));
    }

    /**
     * 获取版本号
     * @param jarName 格式如：log2hdfs-sinker-1.0.1-SNAPSHOT.tar.gz
     * @return
     */
    public static String getVersion(String jarName){
        if(jarName == null){
            return null;
        }
        //若“-”不存在则字符串截取的起始位置为0
        int i = jarName.indexOf("-");
        int begin = jarName.indexOf("-", i+1);

        int end = jarName.indexOf(".tar.gz");
        if(end == -1){
            return null;
        }
        return jarName.substring(begin + 1,end);
    }
}
