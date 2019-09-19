package com.playground.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkamat on 5/20/2018.
 */
public class SubArrayMatchingSum {

    //Function to print subarray with sum as given sum
    static void subArrayMatchingSumHandlesNegative(int arr[], int n, int sum)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int intSum = 0;
        for(int i=0; i<n; i++) {
            intSum = intSum + arr[i];

            if(intSum == sum) {
                System.out.println("Found matching sum at sub array [0 to " + i + "]");
                return;
            }

            if(map.containsKey(intSum - sum)) {
                System.out.println("Found matching sum at sub array [" + map.get(intSum - sum) + " to " + i + "]");
                return;
            }

            map.put(intSum, i);
        }

        System.out.println("Not found");
    }

    private static void subArraySum(int arr[], int n, int sum) {
        for(int i=0; i<n; i++) {
            int intSum = 0;
            for(int j=i; j<n; j++) {
                intSum = intSum + arr[j];

                if(intSum > sum) {
                    break;
                }

                if(intSum == sum) {
                    System.out.println("Subarray matching sum is from index=" + i + " to index=" + j);
                    return;
                }
            }
        }
        System.out.println("No subarray with matching sum found");
    }

    private static void subArraySumOn(int arr[], int n, int sum) {
        int intSum = arr[0];
        for(int i=1; i<n; i++) {
            int start = 0;
            int j = i;
            while(j < n) {

                while(intSum > sum) {
                    intSum = intSum - arr[start];
                    start++;
                }

                if(intSum == sum) {
                    System.out.println("Subarray matching sum start at index=" + start + " to index=" + (j - 1));
                    return;
                }

                intSum = intSum + arr[j];
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {10,2,-2,-20,10};
        int n = arr.length;
        int sum = -10;
        subArrayMatchingSumHandlesNegative(arr, n, sum);
    }
}
