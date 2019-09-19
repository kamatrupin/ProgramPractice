package com.playground.practice.algorithms;

public class MatrixRotation {

    public static void rotateMatrixClockwise(int [][] matrix) {
        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i=first; i<last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left --> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom --> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right --> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top --> right
                matrix[i][last] = top;
            }
        }
    }

    public static void rotateMatrixAntiClockwise(int [][] matrix) {
        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i=first; i<last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left --> bottom
                matrix[first][i] = matrix[i][last];
                // top --> left
                matrix[i][last] = matrix[last][last - offset];
                // right --> top
                matrix[last][last - offset] = matrix[last - offset][first];
                // bottom --> right
                matrix[last - offset][first] = top;
            }
        }
    }

    public static void main(String args[]) {

        int [][] matrix = new int[4][4];
        int val = 1;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(val + " ");
                matrix[i][j] = val;
                val++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        rotateMatrixAntiClockwise(matrix);

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * First loop - layer = 0  to n/2
     * first = layer
     * last = n - i - layer
     *
     * second loop - i=first till i<last
     * offset = i - first
     *
     * first        i
     * last-offset  first
     * last         last-offset
     * i            last
     *
     * left --> top
     * bottom --> left
     * right --> bottom
     * top --> right
     */
}
