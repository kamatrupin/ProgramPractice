package com.playground.practice.algorithms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    private int size;
    private LinkedList<Integer> queue;
    private HashSet<Integer> memory;

    public LRUCache(int size) {
        this.size = size;
        queue = new LinkedList<>();
        memory = new HashSet<>();
    }

    public void refer(int number) {

        if(memory.contains(number)) {
           int i = 0;
           Iterator<Integer> iterator = queue.iterator();
           while(iterator.next() != number) {
               i++;
           }
           queue.remove(i);
        } else {
            if(queue.size() == size) {
                int num = queue.removeLast();
                memory.remove(num);
            }
        }

        queue.push(number);
        memory.add(number);
    }

    public void display() {
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(1);

        cache.display();
    }
}
