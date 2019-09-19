package com.playground.practice.codility.mosaic;

import java.util.*;

public class Solution1 {

    public int solution(int[] T) {

        Set<Integer> sortedSet = new TreeSet<>();

        int j = T.length - 1;
        while(j > 0) {
            boolean isLeftValueGreater = false;
            for(int k=j; k<=T.length-1; k++) {
                for(int i=0; i<j; i++) {
                    if(T[k] < T[i]) {
                        isLeftValueGreater = true;
                        break;
                    }
                }
                if(isLeftValueGreater) {
                    break;
                }
            }

            if(!isLeftValueGreater) {
                sortedSet.add(j);
            }

            j--;
        }

        return sortedSet.stream().findFirst().get();
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int [] T = {5, -2, 3, 8, 6};
//        int [] T = {-5, -5, -5, -42, 6, 12};
        System.out.println(sol.solution(T));
    }
}
