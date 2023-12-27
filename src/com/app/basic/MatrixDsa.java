package com.app.basic;

import java.util.Arrays;
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

    public void transpose(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public void rotate90(int[][] mat, int n) {
        transpose(mat);
        int end = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[end][j];
                mat[end][j] = temp;
            }
            end--;
        }
    }

    public int[] antiDiagonalPattern(int[][] matrix) {
        int[] antDia = new int[matrix.length * matrix.length];
        int start = 0;
        for (int j = 0; j < matrix.length; j++) {
            int col = j;
            for (int i = 0; i <= j; i++) {
                antDia[start++] = matrix[i][col];
                col--;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int row = i;
            for (int j = matrix.length - 1; j >= 0 && row < matrix.length; j--) {
                antDia[start++] = matrix[row][j];
                row++;
            }
        }

        return antDia;
    }


    public static void main(String[] args) {
        MatrixDsa matrixDsa = new MatrixDsa();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = matrixDsa.antiDiagonalPattern(mat);
        System.out.println("mat = " + Arrays.toString(ints));
    }


}
