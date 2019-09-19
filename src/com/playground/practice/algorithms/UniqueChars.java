package com.playground.practice.algorithms;

import java.util.*;

/**
 * Created by rkamat on 5/17/2018.
 */
public class UniqueChars {

    public static void main(String args []) {
        // Only [a-zA-Z]
        String str = "rurpin";
        final List<String> strings = Arrays.asList(str);
        Collections.sort(strings);
        System.out.println(strings);
        boolean result = checkStringEff(str);
        System.out.println(result ? "Unique" : "Not Unique");
    }

    private static boolean checkString(String input) {
        int checker = 0;
        for(int i=0; i<input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    private static boolean checkStringEff(String input) {
        int arr [] = new int[256];

        char [] charArr = input.toCharArray();
        for(char ch : charArr) {
            arr[ch]++;
            if(arr[ch] > 1) {
                return false;
            }
        }
        return true;
    }
}
