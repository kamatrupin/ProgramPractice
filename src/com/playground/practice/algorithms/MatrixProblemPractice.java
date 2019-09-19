package com.playground.practice.algorithms;

public class MatrixProblemPractice {

    // Time complexity = O(m*n)
    // Space = O(m+n)
    public static void modifyMatrix(int [][] matrix) {
        boolean [] rowArr = new boolean[matrix.length];
        boolean [] colArr = new boolean[matrix.length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(rowArr[i] || colArr[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Time complexity = O(m*n)
    // Space = O(1)
    public static void modifyMatrixEff(int [][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(i == 0 && matrix[i][j] == 0) {
                    rowFlag = true;
                }
                if(j == 0 && matrix[i][j] == 0) {
                    colFlag = true;
                }
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            if(rowFlag) {
                matrix[0][i] = 0;
            }
            if(colFlag) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String args []) {
        int[][] matrix = {  {1,   2,  3,  0},
                            {5,   6,  7,  4},
                            {0,  10, 11, 12},
                            {3,   4,  5,  6} };

        modifyMatrixEff(matrix);

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
