package com.app.advance.number_theory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberTheory {

    public int kthFactor(int n, int k) {

        int count = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (k == count) {
                return i;
            }
            if (i % 2 == 0) {
                count++;
            }
        }
        return -1;
    }

    public double power(double base, int power) {
        double result = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                power--;
                result *= base;
            }
            // we have even power now
            power = power >> 1; // divide by 2
            base *= base;
        }
        return result;
    }

    Long squaresInChessBoard(Long N) {
//        return (long) (6 * n * (n + 1)* (2 * n + 1) - n *(n + 1) + Math.pow(N, 3));
        return N * (N + 1) / 6 * (2 * N + 1);
        // code here
    }

    public String fractionToDecimal(int numerator, int denominator) {
        int q = numerator / denominator;
        int r = numerator % denominator;

        StringBuilder ans = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        ans.append(q);
        if (r == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            while (r != 0) {
                if (map.containsKey(r)) {
                    Integer i = map.get(r);
                    ans.insert(i, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r, ans.length());
                    numerator = r * 10;
                    q = numerator / denominator;
                    r = numerator % denominator;
                    ans.append(q);
                }
            }
        }
        return ans.toString();
    }


    public void sieveOfEratosthenes(int upperLimit) {
        if (upperLimit < 2) {
            System.out.println("There are no prime numbers less than or equal to " + upperLimit);
            return;
        }
        boolean[] prime = new boolean[upperLimit + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= upperLimit; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        NumberTheory numberTheory = new NumberTheory();
        double power = numberTheory.power(2.1, 3);
        System.out.println("power = " + power);
    }
}
