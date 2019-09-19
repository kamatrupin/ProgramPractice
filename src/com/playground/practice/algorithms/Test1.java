package com.playground.practice.algorithms;

/**
 * Created by rkamat on 7/27/2018.
 */
public class Test1 {

    String color;

    public Test1(String color) {
        this.color = color;
    }

    public void changeValue(Test1 test) {
        test = new Test1("black");
        System.out.println(test.color);
    }

    public static void main(String args []) {
        Test1 test = new Test1("white");
        test.changeValue(test);
        System.out.println(test.color);
    }
}
