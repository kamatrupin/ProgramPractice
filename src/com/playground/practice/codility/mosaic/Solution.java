package com.playground.practice.codility.mosaic;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        /**
         * state will contain 0, 1, 2 values
         * 0 - OFF (Default)
         * 1 - ON
         * 2 - Shining
         */
        int state [] = new int[A.length];
        Arrays.fill(state, 0);

        int moments = 0;
        for(int i=0; i<A.length; i++) {
            // Shine bulb if the previous one is shining
            // else set it to ON
            if(A[i] - 2 == -1 || state[A[i] - 2] == 2) {
                // Shine the bulb
                state[A[i] - 1] = 2;

                // Shine all the subsequent ON bulbs
                shineSubsequentONBulbs(A, state, A[i]);

                moments++;
            } else {
                // Set the bulb to ON
                state[A[i] - 1] = 1;
            }
        }
        return moments;
    }

    private void shineSubsequentONBulbs(int[] A, int[] state, int i) {
        int k = i - 1;
        while(k < A.length - 1 && state[k + 1] != 0) {
            state[k + 1] = 2;
            k++;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int [] arr = {2,1,3,5,4};
        int [] arr = {2,3,4,1,5};
        System.out.println(sol.solution(arr));
    }
}
