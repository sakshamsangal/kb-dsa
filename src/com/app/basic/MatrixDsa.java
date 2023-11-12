package com.app.basic;

import java.util.List;

public class MatrixDsa {


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        printRow(matrix, 0, 0, n - 1);
        printCol(matrix, n - 1, 1, m - 1);

        printRow(matrix, 2, 0, n - 2);
        return null;
    }

    private void printCol(int[][] matrix, int colNum, int rowStart, int rowEnd) {
        for (int i = rowStart; i <= rowEnd; i++) {
            System.out.println("matrix = " + matrix[i][colNum]);
        }
        System.out.println();
    }


    private void printRow(int[][] matrix, int rowNum, int colStart, int colEnd) {
        for (int i = colStart; i <= colEnd; i++) {
            System.out.println("matrix = " + matrix[rowNum][i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MatrixDsa matrixDsa = new MatrixDsa();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixDsa.spiralOrder(mat);
    }

}
