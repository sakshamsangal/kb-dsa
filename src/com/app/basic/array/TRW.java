package com.app.basic.array;

import java.util.Stack;

public class TRW {
    // Method for maximum amount of water
    int findWater(int[] arr, int n) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by
        // element consider the amount of water on i'th bar,
        // the amount of water accumulated on this
        // particular bar will be equal to min(left[i],
        // right[i]) - arr[i] .
        int[] ans = new int[12];
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
            ans[i] = water;
        }

        return water;
    }

    // Function to return the maximum
    // water that can be stored
    public int maxWater(int[] arr, int n) {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    // Function to return the maximum
    // water that can be stored
    public int maxWater(int[] height) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }

        return ans;
    }

    // 2 pointer
    int maxWater2Pointer(int[] arr, int n) {

        // Indices to traverse the array
        int start = 0;
        int end = n - 1;

        // To store Left max and end max
        // for two pointers leftPointer and end
        int m1 = 0;
        int m2 = 0;

        // To store the total amount
        // of rain water trapped
        int result = 0;
        while (start <= end) {

            // We need check for minimum of leftPointer
            // and end max for each element
            if (m1 <= m2) {
                // Add the difference between
                // current value and leftPointer max at index l
                result += Math.max(0, m1 - arr[start]);

                // Update leftPointer max
                m1 = Math.max(m1, arr[start]);

                // Update leftPointer pointer
                start += 1;
            } else {

                // Add the difference between
                // current value and end max at index r
                result += Math.max(0, m2 - arr[end]);

                // Update end max
                m2 = Math.max(m2, arr[end]);

                // Update end pointer
                end -= 1;

            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    }
}

