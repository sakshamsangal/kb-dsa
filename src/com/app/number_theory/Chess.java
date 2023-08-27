package com.app.number_theory;

public class Chess {
    static Long squaresInChessBoard(Long N) {
//        return (long) (6 * n * (n + 1)* (2 * n + 1) - n *(n + 1) + Math.pow(N, 3));
        return N * (N + 1)/6* (2 * N + 1);
        // code here
    }

    public static void main(String[] args) {
        Long aLong = squaresInChessBoard(3L);
        System.out.println("aLong = " + aLong);
    }
}