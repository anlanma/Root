package com.tl.demos;

/**
 * Created by tanglin on 2015/12/24.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println(getVersion("a-b-1.0.1-SNAPSHOT.tar.gz"));
    }

    /**
     * ��ȡ�汾��
     * @param jarName ��ʽ�磺log2hdfs-sinker-1.0.1-SNAPSHOT.tar.gz
     * @return
     */
    public static String getVersion(String jarName){
        if(jarName == null){
            return null;
        }
        //����-�����������ַ�����ȡ����ʼλ��Ϊ0
        int i = jarName.indexOf("-");
        int begin = jarName.indexOf("-", i+1);

        int end = jarName.indexOf(".tar.gz");
        if(end == -1){
            return null;
        }
        return jarName.substring(begin + 1,end);
    }
}
