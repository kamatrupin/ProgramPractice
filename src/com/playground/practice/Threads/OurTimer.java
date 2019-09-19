package com.playground.practice.Threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkamat on 9/27/2018.
 */
public class OurTimer {

    List<Runnable> runnables = new ArrayList<>();
    Integer duration;

    public void setTimer(Runnable r, Integer duration) throws InterruptedException {
        this.duration = duration;
        runnables.add(r);
    }

    public void executeTask() throws InterruptedException {
        Thread.sleep(duration);
        for(Runnable run : runnables) {
            ((Thread)run).start();
        }
    }

    public static void main(String args []) {
        try {
            OurTimer ourTimer = new OurTimer();
            Thread thread = new Thread(new MyRunnable());
            for(int i=0; i<5; i++) {
                ourTimer.setTimer(thread, 60);
            }

            ourTimer.executeTask();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
