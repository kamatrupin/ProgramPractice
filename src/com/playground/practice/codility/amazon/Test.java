package com.playground.practice.codility.amazon;

public class Test {
    public static void main(String[] args) {
        String str = "John Doe; Peter Parker; Mary Jane Watson-Parker; James Doe; John Elvis Doe; Jane Doe; Penny Parker";
        System.out.println(str.replaceAll("/\\s*,\\s*/, ',', $x", ""));
    }
}
