package com.playground.practice.codility.amazon.ppltech;

import java.util.Random;

public class Solution1 {
    public static String solution(String riddle) {

        if(riddle == null || riddle.isEmpty()) return "";

        StringBuilder sbuf = new StringBuilder();
        char [] charArr = riddle.toCharArray();

        Random rnd = new Random();
        for(int i=0; i<riddle.length(); i++) {
            if(charArr[i] == '?') {
                char ch = (char) (rnd.nextInt(26) + 'a');
                while((i>0 && ch == charArr[i - 1]) || (i<riddle.length()-1 && ch == charArr[i + 1])) {
                    ch = (char) (rnd.nextInt(26) + 'a');
                }
                charArr[i] = ch;
                sbuf.append(ch);
            } else {
                sbuf.append(charArr[i]);
            }
        }

        return sbuf.toString();
    }

    public static void main(String[] args) {
        System.out.println("ab?ac? --> " + solution("ab?ac?"));
        System.out.println("??xv?re? --> " + solution("??xv?re?"));
    }
}
