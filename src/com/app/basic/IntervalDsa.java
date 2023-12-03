package com.app.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalDsa {

    public int[][] insert(int[][] mat, int[] item) {
        List<int[]> ans = new ArrayList<>();
        for (int[] curr : mat) {
            if (curr[1] < item[0]) {
                ans.add(curr);
            } else if (item[1] < curr[0]) {
                ans.add(item);
                item = curr;
            } else {
                item[0] = Math.min(curr[0], item[0]);
                item[1] = Math.max(curr[1], item[1]);
            }
        }
        ans.add(item);
        return ans.toArray(new int[0][]);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[0][]);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[end - 1] + 1 == nums[end]) {
                end++;
                continue;
            }
            // 4
            end--;
            print(nums, list, start, end);
            start = end + 1;
            end = start + 1;
        }
        end--;
        print(nums, list, start, end);
        return list;
    }

    private static void print(int[] nums, List<String> list, int start, int end) {
        if (start == end) {
            list.add(String.format("%s", nums[start]));
        } else {
            list.add(String.format("%s->%s", nums[start], nums[end]));
        }
    }

    public static void main(String[] args) {
        IntervalDsa intervalDsa = new IntervalDsa();
        int[][] arr = {{1, 3}, {7, 9}};
        int[] arr2 = {4, 5};

        int[][] insert = intervalDsa.insert(arr, arr2);
        System.out.println("insert = " + Arrays.deepToString(insert));
    }
}
