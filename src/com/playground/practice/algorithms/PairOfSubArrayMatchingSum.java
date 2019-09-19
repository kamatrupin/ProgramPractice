package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/20/2018.
 */
public class PairOfSubArrayMatchingSum {

    private static void subArraySum(int arr[], int n, int sum) {
        int pair = 0;
        for(int i=0; i<n; i++) {
            int intSum = 0;
            for(int j=i + 1; j<n; j++) {
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
            int start = i;
            int j = i;
            while(j < n) {

                while(intSum > sum) {
                    intSum = intSum - arr[start];
                    start++;
                }

                if(intSum == sum) {
                    System.out.println("Subarray matching sum start at index=" + start + " to index=" + (j - 1));
                }

                intSum = intSum + arr[j];
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {2, 4, 8, 5, 9, 15, 10, 23};
        int n = arr.length;
        int sum = 22;
        subArraySumOn(arr, n, sum);
    }
}
