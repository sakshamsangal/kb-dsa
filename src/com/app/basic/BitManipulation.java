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

    public static void main(String[] args) {
        BitManipulation bitManipulation = new BitManipulation();
        int i = bitManipulation.hammingWeight(5);
        System.out.println("i = " + i);
    }
}
