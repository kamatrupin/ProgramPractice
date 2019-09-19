package com.playground.practice.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rkamat on 9/12/2018.
 */
public class MergeKSortedArrays {

    private class QueueNode implements Comparable<QueueNode> {

        int array;
        int index;
        int value;

        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            if(value > o.value) { return 1; }
            if(value < o.value) { return -1; }
            return 0;
        }
    }

    /**
     *  {1, 4, 8}
     *  {3, 6, 10}
     *  {2, 5, 7, 9}
     *
     *  size = 10
     *  pq = []
     *  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
     */
    public int [] merge(int [][] inputArray) {
        Queue<QueueNode> priorityQueue = new PriorityQueue();

        int size = 0;
        // Add 0th element of each array in the queue
        for(int i=0; i<inputArray.length; i++) {
            size = size + inputArray[i].length;
            priorityQueue.add(new QueueNode(i, 0, inputArray[i][0]));
        }

        int [] results = new int[size];

        for(int i=0; !priorityQueue.isEmpty(); i++) {
            QueueNode node = priorityQueue.poll();
            results[i] = node.value;
            if(node.index+1 < inputArray[node.array].length) {
                priorityQueue.add(new QueueNode(node.array, node.index+1, inputArray[node.array][node.index+1]));
            }
        }

        return results;
    }

    public static void main(String args []) {
        MergeKSortedArrays obj = new MergeKSortedArrays();
        final int[][] arrays = {{1, 4, 8}, {3, 6, 10}, {2, 5, 7, 9}};
        int[] result = obj.merge(arrays);

        for(int val : result) {
            System.out.print(val + " ");
        }
    }
}
