package com.playground.practice.algorithms;

/**
 * Created by rkamat on 7/18/2018.
 */
public class LongestPalindromePractice {

    private static String longestPalStr = "";
    private static int longestPalLen = 0;

    public static void main(String args []) {
        String input = "jklollolkidding";
        runLongestPalindromeCheck(input);
    }

    private static void runLongestPalindromeCheck(String input) {

        Boolean [][] checkArr = new Boolean[input.length()][input.length()];

        // Check Substrings with length=1
        for(int i=0; i<input.length() - 1; i++) {
            checkArr[i][i] = true;
            if(input.substring(i, i + 1).length() > longestPalLen) {
                longestPalLen = input.substring(i, i+1).length();
                longestPalStr = input.substring(i, i+1);
            }
        }

        // Check substrings with length=2
        for(int i=0; i<input.length() - 2; i++) {
            int j = i + 1;
            if(input.charAt(i) == input.charAt(j)) {
                checkArr[i][j] = true;

                if(input.substring(i, j + 1).length() > longestPalLen) {
                    longestPalLen = input.substring(i, j + 1).length();
                    longestPalStr = input.substring(i, j + 1);
                }
            }
        }

        // Check substrings with length>=3
        for(int i=0; i<input.length() - 3; i++) {
        }
    }
}
