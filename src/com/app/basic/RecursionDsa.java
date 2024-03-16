package com.app.basic;

public class RecursionDsa {


    static long sequenceUtil(int start, int len) {
        long prod = 1;
        int sum = start + len;
        for (int i = start; i < sum; i++) {
            prod = (prod * i) % 1000_000_007;
        }
        return prod;
    }

    static long sequence(int n) {
        long sum = 0;
        int start = 1;
        for (int len = 1; len <= n; len++) {
            sum += sequenceUtil(start, len);
            start += len;
        }
        return sum% 1000_000_007;
    }

    public static void main(String[] args) {
        long sequence = sequence(7);
        System.out.println("sequence = " + sequence);
    }
}
