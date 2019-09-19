package com.playground.practice.algorithms;

/**
 * Created by rkamat on 3/25/2018.
 */
public class LongestPalindrome {

    // Finding Longest Palindrome with Dynamic programming
    public static String dynamicProgramming(String str) {
        String palindrome = null;
        int palindromeLength = 0;
        boolean [][] subStrArr = new boolean[str.length()][str.length()];

        // For substring length 1
        for(int i=0; i<str.length() - 1; i++) {
            subStrArr[i][i] = true;
            if(str.substring(i,i+1).length() > palindromeLength) {
                palindrome = str.substring(i,i+1);
                palindromeLength = palindrome.length();
            }
        }

        // For substring length 2
        for(int i=0; i<str.length() - 2; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                subStrArr[i][i + 1] = true;

                if(str.substring(i, i+1+1).length() > palindromeLength) {
                    palindrome = str.substring(i, i+1+1);
                    palindromeLength = palindrome.length();
                }
            }
        }

        for(int k=2; k<str.length(); k++) {
            for(int i=0; i<str.length() - k; i++) {
                int j = i + k;
                if(str.charAt(i) == str.charAt(j) && subStrArr[i + 1][j - 1] == true) {
                    if(str.substring(i, j + 1).length() > palindromeLength) {
                        palindrome = str.substring(i, j + 1);
                        palindromeLength = palindrome.length();
                    }

                    subStrArr[i][j] = true;
                }
            }
        }

        return palindrome;
    }

    public static void main(String args []) {
        String str = "jklollolkidding";

        String palindrome = dynamicProgramming(str);
        int length = palindrome.length();
        System.out.println("The longest palindrome is " + palindrome + " with lenght=" + length);
    }
}
