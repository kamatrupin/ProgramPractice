package com.playground.practice.algorithms;

import java.util.Arrays;
import java.util.Collections;

public class TripletsWithZeroSum {

    private static void findTripletsWithZeroSum(Integer [] array) {

        for(int i=0; i<array.length - 2; i++) {
            int l = i+1;
            int r = array.length - 1;

            while(l < r) {
                if(array[i] + array[l] + array[r] == 0) {
                    System.out.println(array[i] + ", " + array[l] + ", " + array[r]);
                    l++;
                    r--;
                } else if(array[i] + array[l] + array[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {0, -1, 2, -3, 1};

        findTripletsWithZeroSum(arr);
        Collections.sort(Arrays.asList(arr));
    }
}
