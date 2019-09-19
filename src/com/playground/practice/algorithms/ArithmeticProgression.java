package com.playground.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkamat on 9/19/2018.
 */
public class ArithmeticProgression {
    public ArithmeticProgression() {}

    public static void main(String args []) {
        ArithmeticProgression obj = new ArithmeticProgression();
        int [] arr = {1, 3, 3, 4, 6};
        int count = obj.countAP(arr, 5, 1);
        System.out.println(count);
    }

    private int countAP(int[] arr, int n, int d) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxFreq = 0;
        for(int i=0; i<n; i++) {
            int a = arr[i] - (i * d);
            if(hashMap.get(a) != null) {
               hashMap.put(a, hashMap.get(a) + 1);
            } else {
                hashMap.put(a, 1);
            }
            if(hashMap.get(a) > maxFreq) {
                maxFreq = hashMap.get(a);
            }
        }
        return n - maxFreq;
    }
}
