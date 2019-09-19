package com.playground.practice.Threads;

/**
 * Created by rkamat on 9/27/2018.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing a task in MyRunnable");
    }
}