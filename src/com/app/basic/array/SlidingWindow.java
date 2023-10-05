package com.app.basic.array;

public class SlidingWindow {
/*
string
    substring
        filter
*/


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
        int[] arr = {2, 3, 1, 2, 4, 3};

        int len = slidingWindow.minSubArrayLen(7, arr);
        System.out.println("len = " + len);
    }
}
