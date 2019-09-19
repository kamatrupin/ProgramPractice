package com.playground.practice.algorithms;

import java.util.*;

public class SortMapPractice {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Five", 5);
        map.put("Two", 2);
        map.put("one", 1);
        map.put("Three", 3);

        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(map::get));

        treeMap.putAll(map);

        for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
