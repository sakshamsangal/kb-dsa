package com.app.basic.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SlidingWindow {


    // a bcad
    // abc ad
    // aaa aa
    public int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int exp = 0;
        int shr = 0;
        int len = 0;
        int[] freq = new int[128];
        while (exp < s.length()) {
            char c = s.charAt(exp);

            while (freq[c] == 1) {
                freq[s.charAt(shr)]--;
                shr++;
            }
            freq[c]++;
            len = Math.max(len, exp - shr);
            exp++;
        }

        return len + 1;
    }


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
            while (2 < map.size()) {
                if (map.get(fruits[start]) == 1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], val - 1);
                }
                start++;
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


    public int minSubArrayLen2(int target, int[] nums) {
        int exp = 0;
        int shr = 0;
        int currMin = Integer.MAX_VALUE;
        int sum = 0;
        while (exp < nums.length) {
            sum += nums[exp];
            while (sum >= target) {
                currMin = Math.min(currMin, exp - shr);
                sum -= nums[shr];
                shr++;
            }
            exp++;
        }
        return currMin == Integer.MAX_VALUE ? 0 : currMin + 1;
    }


    public int longestkSubstr(String s, int k) {
        if (s.isEmpty()) {
            return -1;
        }
        int exp = 0;
        int shr = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (exp < s.length()) {
            char c = s.charAt(exp);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);

            while (shr < s.length() && map.size() > k) {
                count = map.getOrDefault(s.charAt(shr), 0);
                if (count == 0) {
                    map.remove(s.charAt(shr));
                } else {
                    map.put(c, count - 1);
                }
                shr++;
            }

            if (map.size() == k) {
                len = Math.max(len, exp - shr);
            }

            exp++;


        }
        if (len == 0) {
            return -1;
        }
        return len;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {2, 3, 1, 2, 4, 3};
//        int[] arr = {1, 4, 4};

        int i = slidingWindow.longestkSubstr("aabacbebebe", 3);
        System.out.println("i = " + i);
    }
}
