package com.app.basic.array;

import java.util.ArrayList;
import java.util.List;

public class PermComb {
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
        combinationSumRecur(candidates, target, 0,list);
        return ans;

    }

    private void combinationSumRecur(int[] candidates, int target, int start, List<Integer> ls) {
        if (target == 0) {
            ans.add(ls);
            return;
        }

        if (candidates[start] <= target) {
            // pick
            ls.add(candidates[start]);
            combinationSumRecur(candidates, target - candidates[start], start + 1, ls);
        }

        // ignore
        ls.remove(ls.size() - 1);
        combinationSumRecur(candidates, target, start + 1, ls);
    }

    public static void main(String[] args) {
        PermComb permComb = new PermComb();
        int[] arr = {2,3,6,7};
        permComb.combinationSum(arr, 7);
    }
}
