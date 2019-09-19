package com.playground.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkamat on 5/22/2018.
 */
public class TestProgram {

    private static void subarrayMatchingSum(int arr[], int sum) {
        int length = arr.length;

        int currCum = 0;
        for(int i=0; i<length; i++) {
            currCum = arr[i];
            for(int j=i+1; j<length; j++) {
                currCum = currCum + arr[j];
                if(currCum == sum) {
                    System.out.println("Found subArray from " + i + " to " + j);
                    return;
                }
            }
        }
    }

    private static void subarraymatchingSumOn(int arr[], int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for(int i=0; i<arr.length; i++) {
            curSum = curSum + arr[i];

            if(curSum == sum) {
                System.out.println("Found sub array from 0 to" + i);
                return;
            }

            if(map.containsKey(curSum - sum)) {
                int startIndex = map.get(curSum - sum) + 1;
                System.out.println("Found sub array from " + startIndex + " to " + i);
                return;
            }

            map.put(curSum, i);
        }

        System.out.println("Not found");
    }

    public static void main(String args[]) {
        int [] arr = {2,-10,5,11,-20};
        subarraymatchingSumOn(arr, -14);
    }
}
