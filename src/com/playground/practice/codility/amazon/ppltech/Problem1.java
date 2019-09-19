package com.playground.practice.codility.amazon.ppltech;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Sachin Tendulkar");
        input.add("Rahul Dravid");
        input.add("Saurav Ganguli");
        input.add("Shane Warne");

        input.stream().sorted((s1, s2) ->
                Character.compare(s1.charAt(s1.indexOf(" ") + 2), s2.charAt(s2.indexOf(" ") + 2)))
                .forEach(System.out::println);
    }
}
