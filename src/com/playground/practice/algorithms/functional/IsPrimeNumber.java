package com.playground.practice.algorithms.functional;

import java.util.stream.IntStream;

public class IsPrimeNumber {

    private static boolean isPrime(int number) {
        for(int i=2; i<number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return number > 1;
    }

    private static boolean isPrimeFun(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPrimeFun(1));
        System.out.println(isPrimeFun(2));
        System.out.println(isPrimeFun(3));
        System.out.println(isPrimeFun(4));
        System.out.println(isPrimeFun(5));
    }
}
