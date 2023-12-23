package com.app.advance.dp;

import java.util.Arrays;

public class DpOneDim {

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


    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return minCostTicketsUtil(days, costs, 0, dp);
    }

    int minCostTicketsUtil(int[] days, int[] cost, int start, int[] dp) {
        if (start == days.length) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        // opt 1 hire for 1 day
        int opt1 = cost[0] + minCostTicketsUtil(days, cost, start + 1, dp);

        // opt 2 hire for 7 day
        int j = getInd(days, start, 7);
        int opt2 = cost[1] + minCostTicketsUtil(days, cost, j, dp);

        // opt 3 hire for 30 day
        j = getInd(days, start, 30);
        int opt3 = cost[2] + minCostTicketsUtil(days, cost, j, dp);

        dp[start] = Math.min(opt1, Math.min(opt2, opt3));
        return dp[start];
    }

    int getInd(int[] days, int start, int num) {
        int lastValidDay = days[start] + num - 1;
        int j = start + 1;
        while (j < days.length && days[j] <= lastValidDay) {
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        DpOneDim dpOneDim = new DpOneDim();
        int[] arr = {1, 2, 3};

        int[] values = {2, 2, 3};
        int[] weight = {4, 5, 1};

//        int i = dpDsa.knapSack(4, weight, values, weight.length);

    }


}