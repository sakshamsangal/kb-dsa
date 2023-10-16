package com.app.basic.array;

import java.util.HashMap;
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

    public int totalFruit(int[] fruits) {
        int start = 0;
        int currMax = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            int val = map.getOrDefault(fruits[i], 0);
            map.put(fruits[i], val + 1);
            if (2 < map.size()) {
                while (2 < map.size()) {
                    if (map.get(fruits[start]) == 1) {
                        map.remove(fruits[start]);
                    } else {
                        map.put(fruits[start], val - 1);
                    }
                    start++;
                }
            }
            currMax = Math.max(currMax, i - start);
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

//        int[] arr = {1,2,3,2,2};
        int[] arr = {0, 1, 2, 2};
        int i = slidingWindow.totalFruit(arr);
        System.out.println("i = " + i);
//
//        int len = slidingWindow.minSubArrayLen(7, arr);
//        System.out.println("len = " + len);
    }
}
