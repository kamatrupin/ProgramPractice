package com.playground.practice.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    private static void permutations(String prefix, String suffix, List<String> results) {
        if(suffix.length() == 0) {
            results.add(prefix);
        }

        for(int i=0; i<suffix.length(); i++) {
            permutations(prefix + suffix.charAt(i),
                    suffix.substring(0, i) + suffix.substring(i+1), results);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> results = new ArrayList<>();
        permutations("", str, results);
        System.out.println(results);
    }
}
