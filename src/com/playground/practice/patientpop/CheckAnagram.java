package com.playground.practice.patientpop;

public class CheckAnagram {

    // Assumptions -
    // 1. Char set - [a-zA-Z]
    // 2. The inputs string are not null
    public static boolean checkAnagram(String a, String b) {

        if(a.length() != b.length()) return false;

        int [] charCountArray = new int[256];

        for(int i=0, j=0; i<a.length(); i++, j++) {
            charCountArray[a.toLowerCase().charAt(i)]++;
            charCountArray[b.toLowerCase().charAt(j)]--;
        }

        for(int count : charCountArray) {
            if(count > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("Topt", "PotT"));
    }
}
