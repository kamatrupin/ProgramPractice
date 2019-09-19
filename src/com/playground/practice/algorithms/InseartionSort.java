package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/22/2018.
 */
public class InseartionSort {

    private static void inseartionSort(int [] arr) {
        int len = arr.length;

        for(int i=1; i<len; i++) {
            int place = i;
            int temp = arr[i];
            while(place > 0 && temp < arr[place -1]) {
                arr[place] = arr[place - 1];
                place--;
            }
            arr[place] = temp;
        }
    }

    public static void main(String args []) {
        int [] arr = {8,5,7,4,1,3};
        inseartionSort(arr);
        for(int num : arr) {
            System.out.println(num);
        }
    }
}
