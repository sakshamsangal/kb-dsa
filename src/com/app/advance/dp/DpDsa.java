package com.app.advance.dp;

import java.util.Arrays;

public class DpDsa {

    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int currMax = 1;
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int lis = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis = Math.max(arr[j], lis);
                }
            }
            arr[i] = lis + 1;
            currMax = Math.max(currMax, arr[i]);
        }
        return currMax;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return canPartitionRecur(nums, sum / 2, nums.length - 1, dp);
    }

    private boolean canPartitionRecur(int[] nums, int target, int end, int[] dp) {
        if (end < 0 || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (dp[end] != -1) {
            return dp[end] == 1;
        }
        // include
        boolean a = canPartitionRecur(nums, target - nums[end], end - 1, dp);

        // exclude
        boolean b = canPartitionRecur(nums, target, end - 1, dp);

        boolean res = a || b;
        dp[end] = res ? 1 : 0;
        return res;
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] item : dp) {
            Arrays.fill(item, -1);
        }
        return minDistanceRecur(word1, word2, word1.length(), word2.length(), dp);
    }

    private int minDistanceRecur(String word1, String word2, int l1, int l2, int[][] dp) {

        // "" 123
        // insert
        if (l1 == 0) {
            return l2;
        }

        // 123 ""
        // del
        if (l2 == 0) {
            return l1;
        }

        // equal recur
        if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
            // no op needed
            return minDistanceRecur(word1, word2, l1 - 1, l2 - 1, dp);
        }

        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }

        // 123 129
        // update
        // 129 129
        int up = minDistanceRecur(word1, word2, l1 - 1, l2 - 1, dp);

        // insert
        // 1239     129
        int ins = minDistanceRecur(word1, word2, l1, l2 - 1, dp);

        // del
        // 12    12 9
        int del = minDistanceRecur(word1, word2, l1 - 1, l2, dp);


        int min1 = Math.min(up, ins);
        return dp[l1][l2] = 1 + Math.min(min1, del);
    }

    public int minSwap(int[] nums1, int[] nums2) {

        int count = 0;
        int prev1 = -1;
        int prev2 = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (prev1 < nums1[i] && prev2 < nums2[i]) {

            } else {
                count++;
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
            }
            prev1 = nums1[i];
            prev2 = nums2[i];

        }

        return count;
    }

    public static void main(String[] args) {
        DpDsa dpDsa = new DpDsa();
        int[] arr1 = {0, 4, 4, 5, 9};
        int[] arr2 = {0, 1, 6, 8, 10};
        int i = dpDsa.minSwap(arr1, arr2);
        System.out.println("i = " + i);
    }
}