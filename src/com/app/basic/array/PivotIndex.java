package com.app.basic.array;// Java implementation of the approach


public class PivotIndex {


    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int n = arr.length;
        solve(arr);
//        System.out.print(solve(arr, n));
    }

    private static int solve(int[] arr) {

        int n = arr.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        prefixSum[0] = 0;
        suffixSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];

        }

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i;
            }

        }
        return -1;

    }

}

// This code is contributed by PrinciRaj1992
