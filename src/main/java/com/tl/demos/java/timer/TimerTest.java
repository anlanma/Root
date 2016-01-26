package com.tl.demos.java.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tanglin on 2016/1/25.
 */
public class TimerTest {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Timer t = new Timer();
        t.schedule(task,1000,10000);

        ConcurrentHashMap map = new ConcurrentHashMap();
//        map.putIfAbsent();
//        map.put()
    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {

    }
}
