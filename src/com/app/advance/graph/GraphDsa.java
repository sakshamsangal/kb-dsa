package com.app.advance.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GraphDsa {
    public int orangesRotting(int[][] grid) {

        return 0;
    }

    long minCost(long arr[], int n) {

        PriorityQueue<Long> ropes = new PriorityQueue<>();
        for (long rope : arr) {
            ropes.add(rope);
        }

        long totalCost = 0;
        while (1 < ropes.size()) {
            long rope1 = ropes.remove();
            long rope2 = ropes.remove();
            long newRope = rope1 + rope2;
            totalCost += newRope;
            ropes.add(newRope);
        }

        return totalCost;
    }

    public int countWaysUtil(char[] arr, int start, int[] dp) {
        if (start >= arr.length) {
            return 1;
        }
        if (arr[start] == '0') {
            return 0;
        }
        if (start == arr.length - 1) {
            return 1;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int opt1 = countWaysUtil(arr, start + 1, dp);
        int opt2 = 0;

        if (arr[start] == '1' || (arr[start] == '2' && 47 < arr[start + 1] && arr[start + 1] < 55)) {
            opt2 = countWaysUtil(arr, start + 2, dp);
        }

        dp[start] = opt1 + opt2;

        return dp[start] % 1000000007;
    }

    public int CountWays(String str) {
        char[] arr = str.toCharArray();
        int[] dp = new int[str.length()+1];
        Arrays.fill(dp, -1);
        return countWaysUtil(arr, 0, dp);
    }

    public static void main(String[] args) {
        GraphDsa graphDsa = new GraphDsa();
        int i = graphDsa.CountWays("90");
        System.out.println("i = " + i);
    }
}
