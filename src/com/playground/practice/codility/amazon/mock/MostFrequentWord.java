package com.playground.practice.codility.amazon.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 */
public class MostFrequentWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.isEmpty())
            return null;

        // Sanitize the input string, remove all the special chars before start counting the words.
        return mostFrequentWork(paragraph.replaceAll(",", " ").replaceAll("\\s{2,}", " ").replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().trim(), Arrays.asList(banned));
    }

    private String mostFrequentWork(String para, List<String> banned) {
        String [] arr = para.split(" ");
        Map<String, Integer> map = new HashMap<>();

        int maxFreq = 0;
        String word = null;
        for(String str : arr) {
            if(banned.contains(str))
                continue;

            int frequency = 0;
            if(map.keySet().contains(str)) {
                frequency = map.get(str) + 1;
            } else {
                frequency = 1;
            }
            map.put(str, frequency);

            if(frequency > maxFreq) {
                maxFreq = frequency;
                word = str;
            }
        }

        return word;
    }

    private String mostFrequentWorkUsingStream(String para) {
        return null;
    }

    public static void main(String[] args) {
        MostFrequentWord ob = new MostFrequentWord();
//        String [] bannedWorkds = {"hit"};
//        System.out.println(ob.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", bannedWorkds));
        String [] bannedWorkds = {"a"};
        System.out.println(ob.mostCommonWord("a, a, a, a, b,b,b,c, c", bannedWorkds));
    }
}