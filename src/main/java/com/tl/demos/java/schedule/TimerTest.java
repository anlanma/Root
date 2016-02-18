package com.tl.demos.java.schedule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by tanglin on 16/2/16.
 */
public class TimerTest {
    private static int i;

    private static final Timer timer = new Timer();


    public static void main(String[] args) {
        timer.schedule(new MyTask(),0,10000);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
//        timer.purge();//不需要
    }
    static class MyTask extends TimerTask{

        @Override
        public void run() {
            try {
                System.out.println(i++);
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
