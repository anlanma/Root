package com.tl.demos.java.io;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tanglin on 2016/1/27.
 */
public class FileReaderTest {
    private static String fileName = "E:\\GitHub\\Root\\src\\main\\resources\\data1.txt";
    public static void test(){
        String str = "| aaa |";
        String[] parts = str.split("\\|");
        System.out.println(parts.length);
        for(String part : parts){
            System.out.println(part == null);
            System.out.println(part.equals(""));
            System.out.println("part:"+part);
        }
    }

    public static void main(String[] args) {
//        test();
        readFromFile();

    }
    public static void readFromFile(){
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                System.out.println(StringUtils.isEmpty(tempString));
                System.out.println(tempString == "\\r");
            }
            reader.close();
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
