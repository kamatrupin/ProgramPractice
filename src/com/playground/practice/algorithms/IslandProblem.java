package com.playground.practice.algorithms;

/**
 * Created by rkamat on 5/20/2018.
 */
public class IslandProblem {

    private static boolean[][] traverseFlag = new boolean[5][5];
    private static int[] neighbouringRowInd = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] neighbouringColInd = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int countIsland(int [][] matrix) {

        int count = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(matrix[i][j] == 1 && !traverseFlag[i][j]) {
                    traverseDFS(i, j, matrix);
                    count++;
                }
            }
        }

        return count;
    }

    private static void traverseDFS(int i, int j, int[][] matrix) {
        traverseFlag[i][j] = true;

        for(int ni=0; ni<neighbouringColInd.length; ni++) {
            if((i + neighbouringRowInd[ni] >=0 && i + neighbouringRowInd[ni] < 5)
                    && (j + neighbouringColInd[ni] >= 0 && j + neighbouringColInd[ni] < 5)
                    && matrix[i + neighbouringRowInd[ni]][j + neighbouringColInd[ni]] == 1
                    && !traverseFlag[i + neighbouringRowInd[ni]][j + neighbouringColInd[ni]]) {
                traverseDFS(i + neighbouringRowInd[ni], j + neighbouringColInd[ni], matrix);
            }
        }

    }

    public static void main(String args []) {
        int[][] matrix = {{1, 1, 0, 0, 0},
                         {0, 1, 0, 0, 1},
                         {1, 0, 0, 1, 1},
                         {0, 0, 0, 0, 0},
                         {1, 0, 1, 0, 1}};

        int count = countIsland(matrix);
        System.out.println(count);
    }
}
