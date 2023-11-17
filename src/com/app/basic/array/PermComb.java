package com.app.basic.array;

import com.app.util.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermComb {

    public int robRecur(int[] nums, int[] dp, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (dp[start] == -1) {
            int i = robRecur(nums, dp, start + 2);
            int j = robRecur(nums, dp, start + 1);
            int max = Math.max(nums[start] + i, j);
            dp[start] = max;
            return max;
        }
        return dp[start];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robRecur(nums, dp, 0);
    }

    public int coinChangeRecur(int[] coins, int amount, int end) {
        if (0 < end) {
            return 0;
        }

        // pick
        int i = coinChangeRecur(coins, amount - coins[end], end);

        // ignore
        int j = coinChangeRecur(coins, amount, end - 1);

        return Math.min(1 + i, j);

    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeRecur(coins, amount, coins.length - 1);
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void combineRecur(int start, int end, int k, List<Integer> list) {
        if (k == 0) {
            List<Integer> ls = new ArrayList<>(list);
            ans.add(ls);
            return;
        }
        if (start <= end) {
            // pick
            list.add(start);
            combineRecur(start + 1, end, k - 1, list);

            // ignore
            list.remove(list.size() - 1);
            combineRecur(start + 1, end, k, list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        ans.clear();
        List<Integer> list = new ArrayList<>();
        combineRecur(1, n, k, list);
        return ans;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        List<Integer> list = new ArrayList<>();
        combinationSumRecur(candidates, target, 0, list);
        return ans;

    }

    private void combinationSumRecur(int[] candidates, int target, int start, List<Integer> ls) {
        if (start == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (target < 0) {
            return;
        }

        // pick
        ls.add(candidates[start]);
        combinationSumRecur(candidates, target - candidates[start], start, ls);


        // ignore
        ls.remove(ls.size() - 1);
        combinationSumRecur(candidates, target, start + 1, ls);
    }

    public int climbStairs(int n) {

        return n;
    }


    public void permuteUtil(List<List<Integer>> res, int[] nums, int start) {
        if (start+1 == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            MyUtil.swapArrItem(nums, start, i);

            permuteUtil(res, nums, i + 1);

            MyUtil.swapArrItem(nums,  i, start);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteUtil(list, nums,0);
        return list;
    }

    public static void main(String[] args) {
        PermComb permComb = new PermComb();
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permComb.permute(arr);
        for (List<Integer> list : permute) {
            System.out.println("list = " + list);
        }
    }
}
