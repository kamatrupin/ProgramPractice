package com.playground.practice.algorithms;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by rkamat on 5/23/2018.
 */
public class SortMap {

    public static void main(String args []) {

        Map<String, Integer> map = new TreeMap();
        map.put("aaa", 1);
        map.put("aba", 5);
        map.put("vva", 2);
        map.put("cfaa", 10);
        map.put("rad", 3);

        final Map<String, Integer> sortedMap = sortMap(map);

        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static <K, V extends Comparable> Map<K, V> sortMap(Map<K, V> map) {
        SortedMap<K, V> sortedMap = new TreeMap(new Comparator<V>() {
            @Override
            public int compare(V o1, V o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        sortedMap.putAll(map);
        return sortedMap;
    }
}
