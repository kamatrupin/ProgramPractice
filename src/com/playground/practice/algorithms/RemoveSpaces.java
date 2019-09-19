package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/19/2018.
 */
public class RemoveSpaces {

    private static String removeSpaces(String input) {
        char [] inputArr = input.toCharArray();

        int countNonSpaces = 0;
        for(char ch : inputArr) {
            if(ch != ' ') {
                countNonSpaces++;
            }
        }

        int newLength = inputArr.length;
        int i=0;
        while(i < countNonSpaces) {
            if(inputArr[i] == ' ') {
                for(int j=i; j<inputArr.length - 1; j++) {
                    inputArr[j] = inputArr[j + 1];
                }
                newLength--;
            }
            if(inputArr[i] != ' ') {
                i++;
            }
        }

        return new String(inputArr, 0, countNonSpaces);
    }

    private static String removeSpacesOn(String input) {

        char [] inputArr = input.toCharArray();
        char [] resultArr = new char[inputArr.length];
        int countNonSpaces = 0;
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i] != ' ') {
                resultArr[countNonSpaces] = inputArr[i];
                countNonSpaces++;
            }
        }

        return new String(resultArr, 0, countNonSpaces);
    }

    private static String removeSpaceOnEff(String input) {

        char inputArr [] = input.toCharArray();
        int count = 0;
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i] != ' ') {
                inputArr[count] = inputArr[i];
                count++;
            }
        }

        return new String(inputArr, 0, count);
    }

    public static void main(String args []) {
        System.out.println(removeSpaceOnEff("a b c  d   e "));
    }
}
