package com.playground.practice.algorithms;

public class CheckIfRotationPractice {

    public static boolean isRotation(String s1, String s2) {

        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return false;
        }

        if(s1.length() != s2.length()) {
            return false;
        }

        String s3 = s2 + s2;
        return (s3.indexOf(s1) >= 0);
    }

    public static void main(String args []) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }
}
