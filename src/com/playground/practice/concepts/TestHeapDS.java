package com.playground.practice.concepts;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TestHeapDS {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        queue.add(2);
        queue.add(1);
        queue.add(5);
        queue.add(3);
        queue.add(4);
        queue.add(10);
        queue.add(8);

//        System.out.println(queue);

        Iterator<Integer> interator = queue.iterator();
        while(interator.hasNext()) {
            System.out.println(interator.next());
        }
    }
}
