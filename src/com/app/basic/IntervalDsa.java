package com.app.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalDsa {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i;
        for (i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < newInterval[0]) {
                ans.add(new int[]{interval[0], interval[1]});
            } else {

                int a = newInterval[0];
                int b = newInterval[1];
                int[] prev = ans.get(ans.size() - 1);

                if (prev[1] < a) {
                    ans.add(new int[]{a, b});
                } else {
                    int c = Math.max(prev[1], b);
                    ans.add(new int[]{prev[0], c});
                }
//                ans.add(new int[]{a, Math.max(c, intervals[i+1][1])});

            }
        }
//        for (int j = i; j < intervals.length; j++) {
//            int[] interval = intervals[i];
//            ans.add(new int[]{interval[0], interval[1]});
//        }

        return ans.toArray(new int[0][]);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{start, end});
        }

        return res.toArray(new int[0][]);
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
        int[][] arr = {{1, 3}, {6, 9}};
        int[] arr2 = {2, 5};

        int[][] insert = intervalDsa.insert(arr, arr2);
        System.out.println("insert = " + Arrays.deepToString(insert));
    }
}
