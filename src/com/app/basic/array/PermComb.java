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

}
