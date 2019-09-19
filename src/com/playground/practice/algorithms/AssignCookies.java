package com.playground.practice.algorithms;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int j=0;
        int count = 0;
        for(int i=0; i<s.length; i++) {
            for(; j<g.length; j++) {
                if(s[i] >= g[j]) {
                    count++;
                    j++;
                }
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int [] children = {1, 2, 3};
//        int [] cookies = {1, 1};
//        int [] children = {1, 2};
//        int [] cookies = {1, 2, 3};
        int [] children = {10,9,8,7};
        int [] cookies = {15,6,7,8};
        System.out.println(findContentChildren(children, cookies));
    }
}
