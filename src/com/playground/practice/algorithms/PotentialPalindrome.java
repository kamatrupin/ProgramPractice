package com.playground.practice.algorithms;

import java.util.Arrays;

public class PotentialPalindrome {

    private static int [] arr = new int [256];

    static int NO_OF_CHARS = 256;

    /* function to check whether characters
    of a string can form a palindrome */
    static boolean canFormPalindrome(String str) {

        // Create a count array and initialize all
        // values as 0
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;

        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++)
        {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }

        // Return true if odd count is 0 or 1,
        return true;
    }

    public static boolean isPotentialPalindrome(String str) {

        for(int i=0; i<str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        int oddCount = 0;
        for(int count : arr) {
            if(count % 2 != 0) {
                oddCount++;
            }

            if(oddCount > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "abcabccccd";

        System.out.println(isPotentialPalindrome(str));
    }
}
