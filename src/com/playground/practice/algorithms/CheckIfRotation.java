package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/20/2018.
 */
public class CheckIfRotation {

    private static boolean isSubString(String s1, String s2) {
        return s1.indexOf(s2) >= 0;
    }

    private static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        String s3 = s1 + s1;
        return isSubString(s3, s2);
    }

    public static void main(String args []) {
        boolean result = isRotation("apple", "leapp");
        if(result) {
            System.out.println("s2 is rotation of s1");
        } else {
            System.out.println("s2 is not a rotation of s1");
        }
    }
}
