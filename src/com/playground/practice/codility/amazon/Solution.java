package com.playground.practice.codility.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    static int minimumTime(int numOfParts, List<Integer> parts)
    {
        if(parts == null || parts.isEmpty()) return 0;

        // Sort the list
        Collections.sort(parts);

        int masterSum = 0;
        int sum = parts.get(0);
        for(int i=1; i<numOfParts; i++) {
            sum = sum + parts.get(i);
            masterSum = masterSum + sum;
        }

        return masterSum;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(4, Arrays.asList(8, 4, 6, 12)));
    }
}
