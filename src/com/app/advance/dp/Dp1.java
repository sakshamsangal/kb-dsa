package com.app.advance.dp;

import java.util.Arrays;
import java.util.List;

public class Dp1 {
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
            if (!vis[room]){
                canVisitAllRoomsUtil(rooms, room, vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] vis = new boolean[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            if (!vis[i]){
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

    public static void main(String[] args) {
        Dp1 dp1 = new Dp1();
        int[] arr = {2};
        int i = dp1.coinChange(arr, 3);
        System.out.println("i = " + i);

    }


}
