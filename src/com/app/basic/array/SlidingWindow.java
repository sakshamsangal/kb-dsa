package com.app.basic.array;

import java.util.HashSet;

public class SlidingWindow {


    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<>();
        int currMax = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));

                // change window
                start++;

            } else {

                set.add(s.charAt(end));
                currMax = Math.max(end - start, currMax);

                // change window by moving end
                end++;

            }

            System.out.println("set = " + set);
        }
        return currMax + 1;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                currMin = Math.min(currMin, i - start);
                sum -= nums[start++];
            }
        }

        return currMin == Integer.MAX_VALUE ? 0 : currMin + 1;
    }


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();

        int i = slidingWindow.lengthOfLongestSubstring("pwwkew");
        System.out.println("i = " + i);
//        int[] arr = {2, 3, 1, 2, 4, 3};
//
//        int len = slidingWindow.minSubArrayLen(7, arr);
//        System.out.println("len = " + len);
    }
}
