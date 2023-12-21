package com.app.advance;

import java.util.ArrayList;

public class BackTrack {

    static ArrayList<ArrayList<Integer>> validCombinations = new ArrayList<>();


    private static void boardToList(boolean[][] board) {
        ArrayList<Integer> queenAtRows = new ArrayList<>();
        for (boolean[] row : board) {
            for (int j = 0; j < row.length; j++) {
                if (row[j]) {
                    queenAtRows.add(j + 1);
                }
            }
        }
        validCombinations.add(queenAtRows);
    }

    private static boolean isValidCell(int x, int y, boolean[][] board) {
        for (int i = 0; i < x; i++) {
            if (board[i][y]) {
                return false;
            }
        }
        int col = y - 1;
        int row = x - 1;
        while (-1 < row && -1 < col) {
            if (board[row][col]) {
                return false;
            }
            col--;
            row--;
        }

        col = y + 1;
        row = x - 1;
        while (-1 < row && col < board.length) {
            if (board[row][col]) {
                return false;
            }
            col++;
            row--;
        }
        return true;
    }


    static void nQueenUtil(int row, int col, boolean[][] board) {
        if (row == col) {
            boardToList(board);
            return;
        }
        for (int i = 0; i < col; i++) {
            if (isValidCell(row, i, board)) {
                board[row][i] = true;
                nQueenUtil(row + 1, col, board);
                board[row][i] = false;
            }
        }
    }


    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        validCombinations.clear();

        boolean[][] board = new boolean[n][n];
        nQueenUtil(0, n, board);
        return validCombinations;
    }


    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> list = nQueen(n);
        for (ArrayList<Integer> ls : list) {
            System.out.println("list = " + ls);
        }

    }
}
