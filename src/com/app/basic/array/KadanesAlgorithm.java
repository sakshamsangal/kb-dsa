package com.app.basic.array;

public class KadanesAlgorithm {

    // 9
    // -2 1 -3 4 -1 2 1 -5 4
    // sub-array with maximum sum.
    // max sum that ends at ith index
    // e.g. index = 3
    // 4
    // -3 4
    // 1 -3 4
    // -2 1 -3 4
    // 1 2 3 4 5
    // choice 1: we can start a new sub-array
    // choice 2: add to existing sub-array

    private static int kadaneAlgo(int[] arr, int size) {
        int[] max = new int[size];
        max[0] = arr[0];
        int maximum = max[0];
        for (int i = 1; i < size; i++) {
            max[i] = Math.max(arr[i], arr[i] + max[i - 1]);
            if (maximum < max[i]) maximum = max[i];
        }
        return maximum;
    }

    public static int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int[] arr1 = new int[1];


        for (int i = 0; i <= n - 1; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
            arr1[i] = currSum;

        }

        return maxSum;
    }

    public static int solveMaxSubArrayProblem(int[] input) {
        int n = input.length;
        int globalMaxSum = Integer.MIN_VALUE;
        int localMaxSum = 0;
        int[] arr1 = new int[5];


        for (int i = 0; i < n; i++) {
            localMaxSum = Math.max(input[i], input[i] + localMaxSum);
            arr1[i] = localMaxSum;
            if (localMaxSum > globalMaxSum) {
                globalMaxSum = localMaxSum;
            }
        }

        return globalMaxSum;
    }

    public static void main(String[] args) {
        int[] input = {1, -2, 5, -3, 4};
        int result = solveMaxSubArrayProblem(input);
        System.out.println(result);
    }
}