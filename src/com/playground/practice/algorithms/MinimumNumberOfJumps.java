package com.playground.practice.algorithms;

public class MinimumNumberOfJumps {

    public static void findMinimumNumberOfJumps(int [] arr) {
        int [] numOfJumps = new int[arr.length];
        numOfJumps[0] = 0;
        int [] pathOfJumps = new int[arr.length];

        for(int i=1; i<arr.length; i++) {
            int j=0;
            while(j < i) {
                if(arr[j] >= i-j) {
                    numOfJumps[i] = Math.min(numOfJumps[j] + 1, numOfJumps[i]);
                    pathOfJumps[i] = j;
                }
                j++;
            }
        }

        System.out.println(numOfJumps[arr.length - 1]);
    }

    public static void main(String[] args) {
        int [] arr = {2, 1, 3, 2, 3, 4, 5, 1, 2, 8};
        findMinimumNumberOfJumps(arr);
    }
}
