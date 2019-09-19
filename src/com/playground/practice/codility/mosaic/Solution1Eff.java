package com.playground.practice.codility.mosaic;

public class Solution1Eff {

    public int solution(int[] T) {

        // Create maxLeft and minRight arrays
        // maxLeft[i] = max(0 to i)
        // minRight[i] = min(i to n-1)

        int [] maxLeft = new int[T.length];
        int [] minRight = new int[T.length];

        maxLeft[0] = T[0];
        minRight[T.length - 1] = T[T.length - 1];
        for(int i=1; i<T.length; i++) {
            maxLeft[i] = Math.max(T[i], maxLeft[i-1]);
            minRight[T.length - 1 - i] = Math.min(T[T.length - 1 - i], minRight[T.length - 1 - i + 1]);
        }

        for(int i=0; i<T.length - 1; i++) {
            if(maxLeft[i] < minRight[i+1]) {
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1Eff sol = new Solution1Eff();
        int [] T = {5, -2, 3, 8, 6};
//        int [] T = {-5, -5, -5, -42, 6, 12};
//        int [] T = {5, -2, 3, 1, 8};
        System.out.println(sol.solution(T));
    }
}
