package com.playground.practice.algorithms;

import java.util.Arrays;

/**
 * Created by rkamat on 5/19/2018.
 */
public class AnagramStrings {

    private static boolean anagramCheck(String str1, String str2) {

        if(str1.length() != str2.length()) {
            return false;
        }

        char str1Arr [] = str1.toCharArray();
        char str2Arr [] = str2.toCharArray();

        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);

        return new String(str1Arr).equals(new String(str2Arr));
    }

    private static boolean anagramCheckEff(String str1, String str2) {

        if(str1.length() != str2.length()) {
            return false;
        }

        int [] charSet = new int[256];
        Arrays.fill(charSet, 0);

        for(int i=0; i<str1.length(); i++) {
            charSet[str1.charAt(i)]++;
            charSet[str2.charAt(i)]--;
        }

        for(int i=0; i<256; i++) {
            if(charSet[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args []) {
        // [a-zA-Z]
        boolean anagramCheck = anagramCheckEff("geeksforgaeks", "forgeaksgeeks");
        if(anagramCheck) {
            System.out.println("Given strings are anagram");
        } else {
            System.out.println("Given strings are not anagram");
        }
    }
}
