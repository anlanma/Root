package com.tl.test.demos.java.io;

import java.io.*;

/**
 * Created by tanglin on 16/3/13.
 */
public class FilterTest {
    public static void main(String[] args) {

    }

    public static void filter(){
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("person.txt")));
            dis.readBoolean();

            BufferedReader br = new BufferedReader(new FileReader("person.txt"));
            br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
