package com.playground.practice.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= minHeap.peek()) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        int [][] intervals = {{0,30}, {15,20}, {5,10}};
        System.out.println(minMeetingRooms(intervals));
    }
}
