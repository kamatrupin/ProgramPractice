package com.playground.practice.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    private static int findKthSmallest(Integer [] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.addAll(Arrays.asList(Arrays.copyOfRange(array, 0, k)));

        for(int i=k; i<array.length; i++) {
            if(array[i] < maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.add(array[i]);
            }
        }

        return maxHeap.poll();
    }

    public static void main(String[] args) {
        // 1 3 4 6 7 9
        Integer [] array = {7, 4, 6, 3, 9, 1};
        System.out.println(findKthSmallest(array, 4));
    }
}
