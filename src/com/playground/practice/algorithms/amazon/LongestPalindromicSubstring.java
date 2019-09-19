package com.playground.practice.algorithms.amazon;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        if(s == null || s.isEmpty()) return "";

        String longestPalindromicString = null;
        int maxLen = 0;
        boolean[][] array = new boolean[s.length()][s.length()];

        // Mark all the substrings of length 1 to true in the array
        for(int i=0; i<s.length(); i++) {
            array[i][i] = true;
            longestPalindromicString = updateSubStringIfMaxLen(s.substring(i, i + 1), maxLen, longestPalindromicString);
        }

        // Mark all the substrings of length 2 in the array
        for(int i=0; i<s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                array[i][i+1] = true;
                longestPalindromicString = updateSubStringIfMaxLen(s.substring(i, i + 2), maxLen, longestPalindromicString);
            }
        }

        // Check for the remaining combinations in the string
        for(int k=2; k<=s.length() - 1; k++) {
            for(int i=0; i<s.length()-k; i++) {
                int j=i+k;

                if(array[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    array[i][j] = true;
                    longestPalindromicString = updateSubStringIfMaxLen(s.substring(i, j+1), maxLen, longestPalindromicString);
                }
            }
        }

        return longestPalindromicString;
    }

    private static String updateSubStringIfMaxLen(String subStr, int maxLen, String resStr) {
        if(subStr.length() > maxLen) {
            return subStr;
        }
        return resStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("jklollolkidding"));
    }
}
