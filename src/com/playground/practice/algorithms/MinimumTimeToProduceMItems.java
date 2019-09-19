package com.playground.practice.algorithms;

/**
 *
 * Minimum time required to produce m items
 * Consider n machines which produce same type of items but at different rate i.e., machine 1 takes a1 sec to produce an item, machine 2 takes a2 sec to produce an item. Given an array which contains the time required by ith machine to produce an item. Considering all machine are working simultaneously, the task is to find minimum time required to produce m items.
 *
 * Examples:
 *
 * Input : arr[] = {1, 2, 3}, m = 11
 * Output : 6
 * In 6 sec, machine 1 produces 6 items, machine 2 produces 3 items,
 * and machine 3 produces 2 items. So to produce 11 items minimum
 * 6 sec are required.
 *
 * Input : arr[] = {5, 6}, m = 11
 * Output : 30
 *
 */
public class MinimumTimeToProduceMItems {

    private static int minTime(int [] arr, int m) {

        // Find maxValue
        int maxValue = Integer.MAX_VALUE;

        for(int num : arr) {
            if(num > maxValue) maxValue = num;
        }

        // Range 1 to maxValue
        int low = 1;
        int high = maxValue;
        while(low < high) {
            int mid = (low + high) / 2;

            int sum = 0;
            for(int num : arr) {
                sum = sum + (mid / num);
            }

            if(sum > m)
                high = mid - 1;
            else if (sum < m)
                low = mid;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        int m = 11;

        System.out.println(minTime(arr, m));
    }
}
