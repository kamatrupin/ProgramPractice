package com.playground.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

public class CountOfAllSubArrsMatchingSum {

    private static int countSubarrSum(int [] arr, int sum, int n) {
        int res = 0, curSum = 0;

        Map<Integer, Integer> prevSum = new HashMap<>();

        for(int i=0; i<n; i++) {
            curSum += arr[i];

            if(curSum == sum) {
                res++;
            }

            if(prevSum.containsKey(curSum-sum)) {
                res += prevSum.get(curSum-sum);
            }

            Integer count = prevSum.get(curSum);
            if(count == null) {
                prevSum.put(curSum, 1);
            } else {
                prevSum.put(curSum, count+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr1[] = {10,2,-2,-20,10};
        int n = arr1.length;
        int sum = -10;
        System.out.println(countSubArraysMatchingSum(arr1, sum, n));

        int arr2[] = {9, 4, 20, 3, 10, 5};
        int n2 = arr2.length;
        System.out.println(countSubArraysMatchingSum(arr2, 33, n2));
    }

    /*
        {9, 4, 20, 3, 10, 5}

        sum = 33
        res = 0
        currSum = 9
        i = 0
        arr[i] = 9

        map [
        ]
     */

    public static int countSubArraysMatchingSum(int [] arr, int sum, int n) {
        int res = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {

            currSum = currSum + arr[i];

            if(currSum == sum) {
                res++;
            }

            if(map.containsKey(currSum - sum)) {
                res += map.get(currSum - sum);
            }

            Integer count = map.get(currSum);
            if(count == null) {
                map.put(currSum, 1);
            } else {
                map.put(currSum, count + 1);
            }
        }

        return res;
    }
}
