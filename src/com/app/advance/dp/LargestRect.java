package com.app.advance.dp;

import java.util.Stack;

public class LargestRect {

    //Function to find the largest rectangular area possible in a given histogram.
    public static long getMaxArea(long[] hist, long n) {

        long currMax = Long.MIN_VALUE;
        for (int i = 0; i < hist.length; i++) {

            int width = 1;

            // left
            int j = i - 1;
            while (-1 < j && hist[j] >= hist[i]) {
                width++;
                j--;
            }

            // right
            int k = i + 1;
            while (k < hist.length && hist[k] >= hist[i]) {
                width++;
                k++;
            }
            currMax = Math.max(currMax, hist[i] * width);
        }

        return currMax;
    }


    public static long getMaxArea2(long[] hist, long n) {

        Stack<Integer> stackIdx = new Stack<>();
        long currMax = Long.MIN_VALUE;
        for (int i = 0; i < hist.length; i++) {
            int width = 1;
            stackIdx.push(i);
            currMax = Math.max(currMax, hist[i] * i - stackIdx.peek());
        }

        return currMax;
    }


    public static void main(String[] args) {
        LargestRect largestRect = new LargestRect();

        long[] arr = {6, 2, 5, 4, 1, 5, 6};
        long maxArea = getMaxArea(arr, arr.length);
        System.out.println("maxArea = " + maxArea);

    }

}