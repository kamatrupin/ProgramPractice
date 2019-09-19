package com.playground.practice.algorithms;

public class MissingNumberFromTheArray {

    private static int findMissingNumber(int [] array) {

        int i, total;
        int n = array.length;

        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= array[i];
        return total;
    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 3, 2, 4, 7};
        System.out.println(findMissingNumber(arr));
    }
}
