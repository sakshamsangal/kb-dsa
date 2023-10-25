package com.app.advance.dp;// Recursive JAVA program for
// coin change problem.

import java.util.Arrays;

public class CoinChange {

    // Returns the count of ways we can
    // sum coins[0...n-1] coins to get sum "sum"
    static int count(int[] coins, int n, int sum) {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0)
            return 1;

        // If sum is less than 0 then no
        // solution exists
        if (sum < 0)
            return 0;

        // If there are no coins and sum
        // is greater than 0, then no
        // solution exist
        if (n <= 0)
            return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        int i = count(coins, n - 1, sum);
        int j = count(coins, n, sum - coins[n - 1]);
        return i + j;
    }


    public int coinChangeRecur(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int currMin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = coinChangeRecur(coins, amount - coin, dp);
            if (ans != Integer.MAX_VALUE) {
                currMin = Math.min(currMin, 1 + ans);
            }
        }
        dp[amount] = currMin;
        return currMin;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int i = coinChangeRecur(coins, 11, dp);
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    // Driver code
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
    }
}

// This code is contributed by jyoti369
