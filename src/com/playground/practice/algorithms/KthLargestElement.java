package com.playground.practice.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    private static int findKthLargest(Integer [] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.addAll(Arrays.asList(Arrays.copyOfRange(array, 0, k)));

        for(int i=k; i<array.length; i++) {
            if(array[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(array[i]);
            }
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        // 1 3 4 6 7 9
        Integer [] array = {7, 4, 6, 3, 9, 1};
        System.out.println(findKthLargest(array, 2));
    }
}
