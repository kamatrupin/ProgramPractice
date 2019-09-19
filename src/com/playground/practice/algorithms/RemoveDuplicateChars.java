package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/18/2018.
 */
public class RemoveDuplicateChars {

    public static String removeDuplicatesOn2(char[] inputStrArr) {
        if(inputStrArr == null) {
            return null;
        }

        if(inputStrArr.length <= 1) {
            return new String(inputStrArr);
        }

        int tag = 1;
        for(int i=1; i<inputStrArr.length; i++) {
            int j;
            for(j=0; j<tag; j++) {
                if(inputStrArr[i] == inputStrArr[j]) {
                    break;
                }
            }
            if(j == tag) {
                inputStrArr[tag] = inputStrArr[i];
                tag++;
            }
        }

        if(tag < inputStrArr.length) {
            inputStrArr[tag] = 0;
        }

        return new String(inputStrArr, 0, tag);
    }

    public static String removeDuplicatesOn(char[] inputStrArr) {
        if(inputStrArr == null) {
            return null;
        }

        if(inputStrArr.length <= 1) {
            return new String(inputStrArr);
        }

        int tag = 1;
        boolean [] charSet = new boolean[256];
        charSet[inputStrArr[0]] = true;
        for(int i=1; i<inputStrArr.length; i++) {
            if(!charSet[inputStrArr[i]]) {
                inputStrArr[tag] = inputStrArr[i];
                tag++;
                charSet[inputStrArr[i]] = true;
            }
        }

        if(tag < inputStrArr.length) {
            inputStrArr[tag] = 0;
        }

        return new String(inputStrArr, 0, tag);
    }

    public static void main(String args []) {
        // [a-zA-Z]
        final char[] strArr = "abababa".toCharArray();
        System.out.println(removeDuplicatesOn2(strArr));
        System.out.println(removeDuplicatesOn(strArr));

        // abcd
        // aaaa
        // aabb
        // abababa
        // null
        // a
    }
}
