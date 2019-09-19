package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/20/2018.
 */
public class MatrixProblme {

    private static void matrixManipulation(int[][] matrix) {

        int [] row = new int[4];
        int [] col = new int[4];
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void matrixManipulationSpaceEff(int[][] matrix) {
        // Set flag for row and column if first row/col has 0

        boolean rowFlag = false;
        boolean colFlag = false;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(i == 0 && matrix[i][j] == 0) {
                    rowFlag = true;
                }
                if(j == 0 && matrix[i][j] == 0) {
                    colFlag = true;
                }
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }

        for(int i=1; i<4; i++) {
            for(int j=1; j<4; j++) {
                if(matrix[0][j] == 1 || matrix[i][0] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowFlag) {
            for(int i=0; i<4; i++) {
                matrix[0][i] = 0;
            }
        }

        if(colFlag) {
            for(int i=0; i<4; i++) {
                matrix[i][0 ] = 0;
            }
        }
    }

    public static void main(String args []) {
        int[][] matrix = {  {1,   2,  3,  0},
                            {5,   6,  7,  4},
                            {0,  10, 11, 12},
                            {3,   4,  5,  6}};

        matrixManipulationSpaceEff(matrix);

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
