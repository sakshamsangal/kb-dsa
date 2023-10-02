package com.app.basic.array;


import java.util.Arrays;

public class TwoPointer {
    public int[] twoSum2(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int[] ans = new int[2];

        while (start < end) {
            // success
            if (arr[start] + arr[end] == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            }
            // movement
            if (arr[start] + arr[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return ans;
    }

    public int maxArea(int[] height) {
        int currMax = Integer.MIN_VALUE;

        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            currMax = Math.max(currMax, area);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return currMax;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;

        int answer = n + 1;

        // given a window
        while (end < n) {
            sum += nums[end];

            // valid window
            while (sum >= target) {
                answer = Math.min(answer, end + 1 - start);
                sum -= nums[start++];
            }

            // invalid window
            end++;
        }
        return answer == n + 1 ? 0 : answer;
    }

    public static void main(String[] args) {
        TwoPointer twoPointer = new TwoPointer();
        int[] arr = {2,7,11,15};
        // int[] arr = {1, 1, 1};
//        int i = main.minSubArrayLen(7, arr);
//        System.out.println("i = " + i);

        int[] ints = twoPointer.twoSum2(arr, 13);
        System.out.println("ints = " + Arrays.toString(ints));

    }
}
