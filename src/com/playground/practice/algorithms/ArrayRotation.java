package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/20/2018.
 */
public class ArrayRotation {

    // O(n*d)
    private static void rotateArray(int [] inputArr, int d, int size) {
        for(int i=0; i<d; i++) {
            int temp = inputArr[0];
            int j;
            for(j=1; j<size; j++) {
                inputArr[j - 1] = inputArr[j];
            }
            inputArr[j - 1] = temp;
        }
    }

    // O(n)
    private static void rotateArrayOn(int [] inputArray, int d, int size) {
        int gcd = gcd(d, size);

        for(int i=0; i<gcd; i++) {
            int j = i;
            int k;
            int temp = inputArray[i];

            while(true) {
                k = j + d;

                if(k >= size) {
                    k = k - size;
                }

                if(k == i) {
                    break;
                }

                inputArray[j] = inputArray[k];
                j = k;
            }
            inputArray[j] = temp;
        }
    }

    private static void rotateArrayRightOn(int [] inputArray, int d, int size) {
        // https://www.techiedelight.com/right-rotate-an-array-k-times/
        /**
         * Step 1 - Reverse last k elements
         * Step 2 - Reverse remaining n-k elements
         * Step 3 - Reverse the whole array
         */
    }

    private static int gcd(int d, int size) {
        if(size == 0) {
            return d;
        }
        return gcd(size, d % size);
    }

    public static void main(String args []) {
        final int[] inputArr = {1, 2, 3, 4, 5, 6};
        rotateArrayOn(inputArr, 2, inputArr.length);

        for(int num : inputArr) {
            System.out.print(num + " ");
        }

//        System.out.println(gcd(18, 48));
    }
}
