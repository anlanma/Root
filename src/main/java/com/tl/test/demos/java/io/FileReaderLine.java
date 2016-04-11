package com.tl.test.demos.java.io;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Created by tanglin on 2016/1/27.
 * 通过相对路径和classpath加载文件
 */
public class FileReaderLine {
    private static String fileName = "src/main/resources/data.txt";

    public static void main(String[] args) {
        readFromClasspath();
        readFromRelativePath();
    }

    public static void readFromRelativePath(){
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                //回车换行读入为空字符串并非"\r\n",readLine()专注是内容
                System.out.println(StringUtils.isEmpty(tempString));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public static void readFromClasspath(){
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            InputStream is = FileReaderLine.class.getClassLoader().getResourceAsStream("data.txt");
            reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                //回车换行读入为空字符串并非"\r\n",readLine()专注是内容
                System.out.println(StringUtils.isEmpty(tempString));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
