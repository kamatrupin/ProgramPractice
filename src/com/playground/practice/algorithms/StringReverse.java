package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/18/2018.
 */
public class StringReverse {

    private static String reverse(String input) {

        if(input == null) {
            return null;
        }

        char [] inputStrArr = input.toCharArray();
        int i=0;
        int j=inputStrArr.length - 1;
        while(i < j) {
            char temp = inputStrArr[i];
            inputStrArr[i] = inputStrArr[j];
            inputStrArr[j] = temp;
            i++;
            j--;
        }

        return new String(inputStrArr);
    }

    public static void main(String args []) {
        System.out.println(reverse("rupinr"));
    }
}
