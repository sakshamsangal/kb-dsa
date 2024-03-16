package com.app.basic;

public class BitManipulation {

    public int hammingWeight(int n) {
        int count = 0;
        String string = Integer.toBinaryString(n);
        while (0 < n) {
            // 1 1 0 1 1 0 0
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    private int getPrice(int num, int x) {
        int setBitCount = 0;
        int item = 1 << (x - 1);
        while (num != 0) {
            // xth bit is set
            if ((num & item) != 0) {
                setBitCount++;
            }
            num = num >> x;
        }
        return setBitCount;
    }

    public long findMaximumNumber(long k, int x) {
        int num = 0;
        long sum = 0;
        while (sum <= k) {
            num++;
            sum += getPrice(num, x);
        }
        return num - 1;
    }

    public static void main(String[] args) {
        BitManipulation bitManipulation = new BitManipulation();
        long i = bitManipulation.findMaximumNumber(9L, 1);
        System.out.println("i = " + i);
    }
}
