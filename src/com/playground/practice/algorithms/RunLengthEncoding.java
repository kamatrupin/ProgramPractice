package com.playground.practice.algorithms;

/**
 * Input - wwwwaaadexxxxxx
 * O/P - w4a3d1e1x6
 */
public class RunLengthEncoding {

    public static String encode(String input) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0, j = 0;

        while(i < input.length()) {
            int count = 0;
            while(j < input.length() && (input.charAt(i) == input.charAt(j))) {
                count++;
                j++;
            }

            stringBuffer.append(input.charAt(i)).append(count);

            i=j;
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("wwwwaaadexxxxxx"));
    }
}
