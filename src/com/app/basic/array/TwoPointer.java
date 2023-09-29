package com.app.basic.array;


public class TwoPointer {
    public int maxArea(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {

        }
        return sum;

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
        TwoPointer main = new TwoPointer();
        int[] arr = {2, 3, 1, 2, 4, 3};
        // int[] arr = {1, 1, 1};
        int i = main.minSubArrayLen(7, arr);
        System.out.println("i = " + i);
    }
}
