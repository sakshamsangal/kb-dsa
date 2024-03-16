package com.app.advance.dp;

import java.util.Arrays;
import java.util.List;

public class Dp1D {

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

    public int climbStairsUtil(int n, int[] dp) {
        if (n < 3) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int opt1 = climbStairsUtil(n - 1, dp);
        int opt2 = climbStairsUtil(n - 2, dp);
        dp[n] = opt1 + opt2;
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsUtil(n, dp);
    }

    public int minCostClimbingStairsUtil(int[] cost, int end, int[] dp) {

        if (end < 2) {
            return cost[end];
        }

        if (dp[end] != -1) {
            return dp[end];
        }

        int opt1 = minCostClimbingStairsUtil(cost, end - 1, dp);
        int opt2 = minCostClimbingStairsUtil(cost, end - 2, dp);

        dp[end] = cost[end] + Math.min(opt1, opt2);
        return dp[end];
    }

    public int minCostClimbingStairsMemo(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int opt1 = minCostClimbingStairsUtil(cost, cost.length - 1, dp);
        int opt2 = minCostClimbingStairsUtil(cost, cost.length - 2, dp);

        return Math.min(opt1, opt2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public int coinChangeUtil(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int coinCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int coinCountFromRec = coinChangeUtil(coins, amount - coin, dp);
                if (coinCountFromRec != Integer.MAX_VALUE) {
                    coinCount = Math.min(coinCount, 1 + coinCountFromRec);
                }
            }
        }
        dp[amount] = coinCount;
        return dp[amount];

    }

    public int coinChangeMemo(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int countCount = coinChangeUtil(coins, amount, dp);
        if (countCount == Integer.MAX_VALUE) {
            return -1;
        }
        return countCount;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[0] = amount + 1;// index = amount
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (amount < dp[amount]) {
            return -1;
        }
        return dp[amount];
    }


    public void canVisitAllRoomsUtil(List<List<Integer>> rooms, int src, boolean[] vis) {
        List<Integer> list = rooms.get(src);
        vis[src] = true;
        for (int room : list) {
            if (!vis[room]) {
                canVisitAllRoomsUtil(rooms, room, vis);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] vis = new boolean[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            if (!vis[i]) {
                canVisitAllRoomsUtil(rooms, i, vis);
            }
        }

        for (boolean roomVis : vis) {
            if (!roomVis) {
                return false;
            }
        }
        return true;
    }

    public int totalWaysUtil(int N, int start, int[] dp) {
        if (N == 1) {
            return 2;
        }
        if (start >= N) {
            return 1;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int pick = totalWaysUtil(N, start + 2, dp);
        int skip = totalWaysUtil(N, start + 1, dp);
        int m = (int) 1e9+7;
        dp[start] = ((pick % m) + (skip % m))%m;
        return dp[start];
    }

    public int TotalWays(int N) {
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        int ways = totalWaysUtil(N, 0, dp);
        return ways * ways % 1000_000_007;
    }

    public static void main(String[] args) {
        Dp1D dp1D = new Dp1D();
        int[] arr = {1, 2, 3};

        int[] values = {2, 2, 3};
        int[] weight = {4, 5, 1};

//        int i = dpDsa.knapSack(4, weight, values, weight.length);

    }


}