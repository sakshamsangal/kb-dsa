package com.app.advance.dp;

import java.util.Arrays;

public class DpTwoDim {

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

    static int longestSubsequence(int size, int a[]) {
        return lengthOfLIS2(a, -1,0);
    }

    public static int lengthOfLIS2(int[] nums, int prev, int start) {
        if (start == nums.length) {
            return 0;
        }

        int pick = 0;

        if (prev == -1 || nums[prev] < nums[start]) {
            pick = 1 + lengthOfLIS2(nums, start, start + 1);
        }

        int skip = lengthOfLIS2(nums, prev, start + 1);

        return Math.max(pick, skip);

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


    public long count(int[] coins, int len, int sum) {

        if (sum == 0) {
            return 1;
        }
        if (len == 0) {
            return 0;
        }


        // skip
        if (coins[len - 1] > sum) {
            return count(coins, len - 1, sum);
        }

        long pick = count(coins, len, sum - coins[len - 1]);
        long skip = count(coins, len - 1, sum);

        return pick + skip;
    }


    public int knapSackUtil(int W, int wt[], int val[], int n, int[][] dp) {

        if (n == 0) {
            return 0;
        }

        if (dp[n - 1][W] != -1) {
            return dp[n - 1][W];
        }

        if (wt[n - 1] > W) {
            dp[n - 1][W] = knapSackUtil(W, wt, val, n - 1, dp);
            return dp[n - 1][W];
        }

        // pick
        int pick = val[n - 1] + knapSackUtil(W - wt[n - 1], wt, val, n - 1, dp);

        // skip
        int skip = knapSackUtil(W, wt, val, n - 1, dp);

        dp[n - 1][W] = Math.max(pick, skip);
        return dp[n - 1][W];
    }

    public int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[W + 1];
            Arrays.fill(dp[i], -1);
        }
        return knapSackUtil(W, wt, val, n, dp);
    }

    public int editDistanceUtil(String s, String t, int srcEnd, int trgEnd, int[][] dp) {

        if (srcEnd < 0) {
            return trgEnd + 1;
        }

        if (trgEnd < 0) {
            return srcEnd + 1;
        }

        if (dp[srcEnd][trgEnd] != -1) {
            return dp[srcEnd][trgEnd];
        }

        if (s.charAt(srcEnd) == t.charAt(trgEnd)) {
            return editDistanceUtil(s, t, srcEnd - 1, trgEnd - 1, dp);
        }

        // 123 789
        int add = 1 + editDistanceUtil(s, t, srcEnd, trgEnd - 1, dp); // 1239
        int remove = 1 + editDistanceUtil(s, t, srcEnd - 1, trgEnd, dp); // 12
        int replace = 1 + editDistanceUtil(s, t, srcEnd - 1, trgEnd - 1, dp); // 129

        int ans1 = Math.min(add, remove);
        return dp[srcEnd][trgEnd] = Math.min(ans1, replace);

    }

    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[t.length()];
            Arrays.fill(dp[i], -1);
        }

        return editDistanceUtil(s, t, s.length() - 1, t.length() - 1, dp);
    }


    public static void main(String[] args) {
        DpTwoDim dpTwoDim = new DpTwoDim();
        int[] arr = {1, 2, 3};

        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};

        int i = dpTwoDim.knapSack(4, weight, values, weight.length);
        System.out.println("i = " + i);

    }


}