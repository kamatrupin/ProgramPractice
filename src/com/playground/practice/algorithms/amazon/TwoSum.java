package com.playground.practice.algorithms.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [1, 11, 2, 7, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            if(sum == target) {
                return new int[]{0, i};
            }

            if(map.containsKey(sum - target)) {
                return new int[]{map.get(sum - target) + 1, i};
            }
            map.put(sum, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
//        int [] input = {2, 7, 11, 15};
        int [] input = {1, 11, 2, 7, 15};
        System.out.println(Arrays.toString(twoSum(input, 20)));
    }
}
