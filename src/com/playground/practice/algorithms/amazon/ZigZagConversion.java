package com.playground.practice.algorithms.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        Map<Integer, StringBuilder> map = new HashMap<>();

        int row=0;
        int ch=0;
        boolean goingDown = true;
        while(ch < s.length()) {

            if(map.get(row) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(ch));
                map.put(row, sb);
            } else {
                map.get(row).append(s.charAt(ch));
            }

            if(goingDown && row == numRows - 1) {
                goingDown = false;
            } else if(!goingDown && row == 0) {
                goingDown = true;
            }

            if(goingDown) {
                row++;
            } else {
                row--;
            }

            ch++;
        }

        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
