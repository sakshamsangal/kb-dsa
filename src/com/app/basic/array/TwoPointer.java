package com.app.basic.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {


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


    public void twoSum(int[] numbers, int target, int start, List<List<Integer>> ans) {

        int end = numbers.length - 1;

        // at-least 2 item
        while (start < end) {

            while (start + 1 < numbers.length && numbers[start] == numbers[start + 1]) {
                start++;
            }
            while (-1 < end - 1 && numbers[end - 1] == numbers[end]) {
                end--;
            }

            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                ans.add(List.of(-target, numbers[start], numbers[end]));
                return;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] arr) {
        ans.clear();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (-1 < i - 1 && arr[i - 1] == arr[i]) {
                continue;
            }
            twoSum(arr, -arr[i], i, ans);
        }
        return ans;
    }


    public int trap(int[] height) {

        int start = 0;
        int leftMax = 0;
        int rightMax = 0;
        int end = height.length - 1;

        int water = 0;

        while (start < end) {

            if (height[start] < height[end]) {
                leftMax = Math.max(leftMax, height[start]);
                water = water + leftMax - height[start];
                start++;
            } else {
                rightMax = Math.max(rightMax, height[end]);
                water = water + rightMax - height[end];
                end--;
            }
        }

        return water;
    }

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int targetSumCount = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == k) {
                targetSumCount++;
                start++;
                end--;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }

        return targetSumCount;
    }


    public static void main(String[] args) {
        TwoPointer twoPointer = new TwoPointer();
        int[] arr = {4, 2, 0, 3, 2, 5};
        // int[] arr = {1, 1, 1};
//        int i = main.minSubArrayLen(7, arr);
//        System.out.println("i = " + i);
        int trap = twoPointer.trap(arr);
        System.out.println("trap = " + trap);

    }
}
