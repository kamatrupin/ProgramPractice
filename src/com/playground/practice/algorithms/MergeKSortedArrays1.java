package com.playground.practice.algorithms;

import java.util.PriorityQueue;

public class MergeKSortedArrays1 {

    /**
     *  {1, 4, 8}
     *  {3, 6, 10}
     *  {2, 5, 7, 9}
     *
     *  size = 10
     *  pq = []
     *  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
     */
    public static void main(String args []) {
        MergeKSortedArrays1 obj = new MergeKSortedArrays1();
        final int[][] arrays = {{1, 4, 8}, {3, 6, 10}, {2, 5, 7, 9}};
        int[] result = obj.mergeArrays(arrays);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] mergeArrays(int [][] arrays) {

        PriorityQueue<QueueNode> queue = new PriorityQueue<>();

        int resultSize = 0;
        for(int i=0; i<arrays.length; i++) {
            resultSize += arrays[i].length;
            queue.add(new QueueNode(arrays[i][0], i, 0));
        }

        int [] results = new int[resultSize];
        for(int i=0; !queue.isEmpty(); i++) {
            QueueNode qn = queue.poll();
            results[i] = qn.value;

            if(qn.n < arrays[qn.k].length - 1) {
                queue.add(new QueueNode(arrays[qn.k][qn.n + 1], qn.k, qn.n + 1));
            }
        }

        return results;
    }

    public class QueueNode implements Comparable<QueueNode> {

        int value, k, n;

        public QueueNode(int value, int k, int n) {
            this.value = value;
            this.k = k;
            this.n = n;
        }

        @Override
        public int compareTo(QueueNode o) {
            if(this.value > o.value) return 1;
            if(this.value < o.value) return -1;
            return 0;
        }
    }
}
