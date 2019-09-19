package com.playground.practice.codility.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionEff {

    static int minimumTime(int numOfParts, List<Integer> parts)
    {
        if(parts == null || parts.isEmpty()) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        parts.stream().forEach(minHeap::add);

        Integer sum = 0;
        while(minHeap.size() > 1) {
            int intSum = minHeap.poll() + minHeap.poll();
            sum += intSum;
            minHeap.add(intSum);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(4, Arrays.asList(8, 4, 6, 12)));
    }
}
