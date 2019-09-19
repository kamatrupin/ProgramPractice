package com.playground.practice.algorithms;

public class SubArrayMatchingSumNonNegative {

    private static void subArrayMatchingSum(int arr [], int sum) {
        int tempSum = arr[0];
        int start = 0;
        for(int i=1; i<arr.length; i++) {

            while(tempSum > sum && start < i-1) {
                tempSum = tempSum - arr[start];
                start++;
            }

            if(tempSum == sum) {
                System.out.println("Sub Arr=" + start + " to " + (i-1));
            }

            tempSum = tempSum + arr[i];
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 4, 20, 3, 10, 5};

        subArrayMatchingSum(arr, 39);
    }
}
