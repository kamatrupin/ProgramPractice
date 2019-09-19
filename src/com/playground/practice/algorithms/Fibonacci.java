package com.playground.practice.algorithms;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibo(9));
        printFibo(9);
    }

    public static int fibo(int n) {

        int a = 0, b = 1, c = 0;

        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void printFibo(int n) {

        int a = 0, b = 1, c = 0;
        System.out.println(a);
        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }
}
