package com.app.advance.dp;

import java.util.Arrays;

public class Dp2D {

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = maximizeCutsUtil(n, x, y, z, dp);
        return Math.max(ans, 0);
    }

    public int maximizeCutsUtil(int n, int x, int y, int z, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int first = 1 + maximizeCutsUtil(n - x, x, y, z, dp);
        int sec = 1 + maximizeCutsUtil(n - y, x, y, z, dp);
        int third = 1 + maximizeCutsUtil(n - z, x, y, z, dp);

        dp[n] = Math.max(Math.max(first, sec), third);
        return dp[n];
    }


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
        return lengthOfLIS2(a, -1, 0);
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


    public int knapSackUtil1(int W, int wt[], int val[], int[][] dp, int start) {
        if (start == wt.length) {
            return 0;
        }

        if (dp[start][W] != -1) {
            return dp[start][W];
        }

        int minVal = 0;
        for (int i = start; i < wt.length; i++) {
            if (wt[i] <= W) {
                int pick = val[i] + knapSackUtil1(W - wt[i], wt, val, dp, i + 1);
                minVal = Math.max(minVal, pick);
            }
        }

        return dp[start][W] = minVal;
    }


    public int robUtil(int[] nums, int start, int[] dp) {

        if (start >= nums.length) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int minVal = 0;
        for (int i = start; i < nums.length; i++) {
            int pick = nums[i] + robUtil(nums, i + 2, dp);
            minVal = Math.max(minVal, pick);
        }

        return dp[start] = minVal;
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + dp[i - 2];
        }

        return 0;
    }


    public int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[W + 1];
            Arrays.fill(dp[i], -1);
        }
        return knapSackUtil1(W, wt, val, dp, 0);
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


    static int minJumps(int[] arr, int end) {
        if (end == 0) {
            return 0;
        }

        int ans = -1;
        for (int i = 0; i < end; i++) {
            if (i + arr[i] >= end) {
                int res = minJumps(arr, i);
                if (res != -1) {
                    ans = Math.min(ans, res + 1);
                }
            }
        }
        return ans;
    }


    public int uniquePathsUtil(int x, int y, int row, int col, int[][] dp) {

        if (x == row - 1 && y == col - 1) {
            return 1;
        }
        if (x == row || y == col) {
            return 0;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int opt1 = uniquePathsUtil(x, y + 1, row, col, dp);// right
        int opt2 = uniquePathsUtil(x + 1, y, row, col, dp); // down

        dp[x][y] = opt1 + opt2;
        return dp[x][y];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[n];
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsUtil(0, 0, m, n, dp);
    }


    public int uniquePathsTab(int m, int n) {
        int[][] dpChoices = new int[m][n];
        for (int i = 0; i < dpChoices.length; i++) {
            dpChoices[i] = new int[n];
        }
        for (int i = 0; i < n; i++) {
            dpChoices[m - 1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dpChoices[i][n - 1] = 1;
        }

        int row = m - 2;
        int col = n - 2;
        for (int i = row; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                dpChoices[i][j] = dpChoices[i][j + 1] + dpChoices[i + 1][j];
            }
        }
        return dpChoices[0][0];
    }

    public int longestCommonSubsequenceUtil(char[] text1, char[] text2, int start1, int start2, int[][] dpChoices) {
        if (start1 == text1.length || start2 == text2.length) {
            return 0;
        }

        if (dpChoices[start1][start2] != -1) {
            return dpChoices[start1][start2];
        }
        if (text1[start1] == text2[start2]) {
            dpChoices[start1][start2] = 1 + longestCommonSubsequenceUtil(text1, text2, start1 + 1, start2 + 1, dpChoices);
            return dpChoices[start1][start2];
        }

        // abc def
        int opt1 = longestCommonSubsequenceUtil(text1, text2, start1, start2 + 1, dpChoices); // a==e
        int opt2 = longestCommonSubsequenceUtil(text1, text2, start1 + 1, start2, dpChoices); // d==b

        dpChoices[start1][start2] = Math.max(opt1, opt2);
        return dpChoices[start1][start2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        int[][] dpChoices = new int[text1.length()][text2.length()];
        for (int i = 0; i < dpChoices.length; i++) {
            dpChoices[i] = new int[text2.length()];
            Arrays.fill(dpChoices[i], -1);
        }
        return longestCommonSubsequenceUtil(ch1, ch2, 0, 0, dpChoices);
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        int[][] dpChoices = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dpChoices.length; i++) {
            dpChoices[i] = new int[text2.length() + 1];
        }

        for (int i = 0; i < ch2.length + 1; i++) {
            dpChoices[0][i] = 0;
        }

        for (int i = 0; i < ch1.length + 1; i++) {
            dpChoices[i][0] = 0;
        }

        for (int i = 1; i < ch1.length + 1; i++) {
            for (int j = 1; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    dpChoices[i][j] = 1 + dpChoices[i - 1][j - 1];
                } else {
                    // abc def
                    int opt1 = dpChoices[i][j - 1]; // a==e
                    int opt2 = dpChoices[i - 1][j]; // a==e
                    dpChoices[i][j] = Math.max(opt1, opt2);
                }
            }
        }
        return dpChoices[ch1.length][ch2.length];
    }

    // return earning
    public int maxProfitUtil(int[] prices, int day, int buy, int[][] dpChoices) {
        if (day >= prices.length) {
            return 0;
        }
        if (dpChoices[day][buy] != -1) {
            return dpChoices[day][buy];
        }

        // buy
        int earning;

        if (buy == 1) {
            int opt1 = -prices[day] + maxProfitUtil(prices, day + 1, 0, dpChoices);

            // don't buy
            int opt2 = maxProfitUtil(prices, day + 1, 1, dpChoices);
            earning = Math.max(opt1, opt2);

        } else {
            // sell
            int opt3 = prices[day] + maxProfitUtil(prices, day + 2, 1, dpChoices);

            // don't sell
            int opt4 = maxProfitUtil(prices, day + 1, 0, dpChoices);
            earning = Math.max(opt3, opt4);
        }

        dpChoices[day][buy] = earning;

        return dpChoices[day][buy];

    }

    public int maxProfit(int[] prices) {
        int[][] dpChoices = new int[prices.length][];
        for (int i = 0; i < dpChoices.length; i++) {
            dpChoices[i] = new int[2];
            Arrays.fill(dpChoices[i], -1);
        }

        return maxProfitUtil(prices, 0, 1, dpChoices);
    }

    public int findTargetSumWaysUtil(int[] nums, int target, int start, int sum) {
        if (start == nums.length) {
            return 0;
        }
        if (sum == target) {
            return 1;
        }

        int opt1 = findTargetSumWaysUtil(nums, target, start + 1, sum + nums[start]);
        int opt2 = findTargetSumWaysUtil(nums, target, start + 1, sum - nums[start]);

        int ways = opt1 + opt2;
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysUtil(nums, target, 0, 0);
    }

    public static void main(String[] args) {
        Dp2D dp2Dim = new Dp2D();
        int[] arr = {1, 2, 3};

        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};

        int i = dp2Dim.knapSack(4, weight, values, weight.length);
        System.out.println("i = " + i);

    }


}