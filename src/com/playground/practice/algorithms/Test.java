package com.playground.practice.algorithms;

/**
 * Created by rkamat on 7/27/2018.
 */
public class Test {

    public void changeValue(int x, int y) {
        x = y;
        System.out.println(x);
    }

    public static void main(String args []) {
        int a = 5;
        int b = 6;

        Test test = new Test();
        System.out.println(a);
        test.changeValue(a, b);
        System.out.println(a);
    }
}
