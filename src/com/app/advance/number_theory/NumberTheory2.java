package com.app.advance.number_theory;

import java.util.ArrayList;
import java.util.List;

public class NumberTheory2 {

    public int kthFactor(int n, int k) {
        return n;
    }

    public long PowMod(long base, long power, long m) {

        long ans = 1;
        while (power != 0) {
            if (power % 2 == 0) {
                base = (base * base) % m;
                power = power / 2;
            } else {
                ans = (ans * base) % m;
                power = power - 1;
            }
        }
        return ans;
    }


    Long squaresInChessBoard(Long N) {
//        return (long) (6 * n * (n + 1)* (2 * n + 1) - n *(n + 1) + Math.pow(N, 3));
        return N * (N + 1) / 6 * (2 * N + 1);
        // code here
    }

    public String fractionToDecimal(int numerator, int denominator) {

        return null;
    }


    static ArrayList<Integer> sieveOfEratosthenes(int limit) {
        boolean[] comp = new boolean[limit + 1];
        comp[1] = true;
        int i = 2;
        while (i * i <= limit) {
            if (!comp[i]) {
                int j = i * i;
                while (j <= limit) {
                    comp[j] = true;
                    j = j + i;
                }
            }
            i++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 2; j <= limit; j++) {
            if (!comp[j]) {
                list.add(j);
            }
        }

        return list;
    }

    public int trailingZeroes(int n) {
        n++;
        int count = 0;
        int lastDigit = 1;
        for (int i = 1; i < n; i++) {
            int f = lastDigit * i;
            System.out.println("lastDigit = " + lastDigit);
            lastDigit = f % 10;
            while (lastDigit == 0) {
                f = f / 10;
                lastDigit = f % 10;
                count++;
            }
        }
        return count;
    }


    public static int countSetBits(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;

            int k = i;
            while (k != 0) {
                k = k & (k - 1);
                count++;
            }
            sum += count;
        }
        return sum;
    }


    public int binaryExp(int base, int power) {
        int ans = 1;
        while (power != 0) {
            if (power % 2 == 0) {
                base = (base * base) % 10;
                power = power / 2;
            } else {
                ans = (ans * base) % 10;
                power = power - 1;
            }
        }
        return ans;
    }


    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] arr = variables[i];
            int temp = binaryExp(arr[0], arr[1] * arr[2]) % arr[3];
            if (temp == target) {
                ans.add(i);
            }
        }
        return ans;
    }


    int[][] reduceMatrix(int[][] matrix, int size, int colToSkip) {
        int[][] reducedMat = new int[size - 1][];
        int a = 0;
        for (int i = 1; i < size; i++) {
            reducedMat[a] = new int[size - 1];
            int b = 0;
            for (int j = 0; j < size; j++) {
                if (j != colToSkip) {
                    reducedMat[a][b] = matrix[i][j];
                    b++;
                }
            }
            a++;
        }
        return reducedMat;
    }

    int determinantOfMatrix(int matrix[][], int n) {
        if (n == 1) {
            return matrix[0][0];
        }

        int sign = 1;
        int det = 0;
        for (int j = 0; j < n; j++) {
            int[][] reduceMat = reduceMatrix(matrix, n, j);
            det += sign * matrix[0][j] * determinantOfMatrix(reduceMat, n - 1);
            sign = -1 * sign;
        }

        return det;
    }

    public static void main(String[] args) {
        NumberTheory2 numberTheory = new NumberTheory2();
        int[][] arr = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}, {6, 1, 1, 4}};
        numberTheory.determinantOfMatrix(arr, 4);
    }
}
