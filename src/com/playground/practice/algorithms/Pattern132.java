package com.playground.practice.algorithms;

import java.util.Arrays;

public class Pattern132 {

    // O(n3)
    public static boolean find132patternB1(int[] nums) {

        for(int i=0; i<nums.length - 2; i++) {
            for(int k=i+1; k<nums.length-1; k++) {
                for(int j=k+1; j<nums.length; j++) {
                    if(nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }

        return false;
    }

    // O(n2)
    public static boolean find132patternB2(int[] nums) {

        for(int i=0; i<nums.length - 2; i++) {
            for(int j=i+2; j<nums.length; j++) {
                if(nums[j] < nums[i]) {
                    continue;
                }
                int [] tempRange = Arrays.copyOfRange(nums, i + 1, j);
                Arrays.sort(tempRange);
                if(tempRange[tempRange.length - 1] > nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // O(n2)
    public static boolean find132patternB3(int[] nums) {
        int minI = Integer.MAX_VALUE;
        for(int j=0; j<nums.length; j++) {
            minI = Math.min(minI, nums[j]);
            for(int k=j+1; k<nums.length; k++) {
                if(nums[k] < nums[j] && minI < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find132patternEff(int[] nums) {
        return false;
    }

    public static void main(String[] args) {
//        int [] arr = {1, 2, 3, 4};
//        int [] arr = {3, 1, 4, 2};
//        int [] arr = {1,0,1,-4,-3};
        int [] arr = {3, 5, 0, 3, 4};
//        int [] arr = {7, 5, 0, 8, 6};
        System.out.println(find132patternB3(arr));
    }
}
