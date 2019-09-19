package com.playground.practice.concepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        for(Integer val : intList) {
            if(val.equals(3)) {
                intList.remove(val);
            }
        }
    }
}
