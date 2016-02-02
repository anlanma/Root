package com.tl.demos.java.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tanglin on 2016/1/26.
 */
public class CASTest {
    private static AtomicBoolean running = new AtomicBoolean(true);
    public static void main(String[] args) {
        //compareAndSet为false时只执行一次
        while (running.compareAndSet(false,true)){
            System.out.println(running.get());
        }
        System.out.println("out");

    }
}
