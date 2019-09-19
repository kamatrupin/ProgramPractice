package com.playground.practice.algorithms.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
// Usind sliding window technique
public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.isEmpty()) return 0;

        int left = 0, right = 0, max = 0;
        Set<Character> charSet = new HashSet<>();

        while(right < s.length()) {
            if(charSet.add(s.charAt(right))) {
                right++;
                max = Math.max(max, right - left);
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));
    }
}
