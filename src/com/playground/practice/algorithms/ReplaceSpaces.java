package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/19/2018.
 */
public class ReplaceSpaces {

    private static String replaceSpaces(String input) {
        int length = input.length();
        int spaceCount = 0;
        int newLenght = 0;

        for(char ch : input.toCharArray()) {
            if(ch == ' ') {
                spaceCount++;
            }
        }

        newLenght = length + spaceCount * 2;
        char [] resArr = new char[newLenght];

        for(int i=input.length()-1; i>=0; i--) {
            if(input.charAt(i) == ' ') {
                resArr[newLenght-1] = '0';
                resArr[newLenght-2] = '2';
                resArr[newLenght-3] = '%';
                newLenght = newLenght - 3;
            } else {
                resArr[newLenght-1] = input.charAt(i);
                newLenght--;
            }
        }

        return new String(resArr);
    }

    public static void main(String args []) {
        System.out.println(replaceSpaces("ab c   d       ef g  h "));
    }
}
