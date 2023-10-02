package com.app.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    List<List<Integer>> ans = new ArrayList<>();

    public void twoSum(int[] arr, int a, int start, int end, int target) {
        while (start < end) {
            if (0 < start && arr[start - 1] == arr[start]) {
                start++;
                continue;
            }
            // success
            if (arr[start] + arr[end] == target) {
                ans.add(List.of(a, arr[start], arr[end]));
                start++;
            }

            // movement
            else if (arr[start] + arr[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] arr) {
        ans.clear();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                twoSum(arr, arr[i], i + 1, arr.length - 1, -1 * arr[i]);
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = twoSum.threeSum(arr);
        System.out.println("lists = " + lists);

    }
}
