package com.app.advance.dp;

public class DpDsa {

    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int currMax = 1;
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int lis = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis = Math.max(arr[j], lis);
                }
            }
            arr[i] = lis+1;
            currMax = Math.max(currMax, arr[i]);
        }
        return currMax;
    }

    public static void main(String[] args) {
        DpDsa dpDsa = new DpDsa();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = dpDsa.lengthOfLIS(arr);
        System.out.println("i = " + i);
    }

    // the subsequence has to be end with any element
    // i am finding every subsequence ending with arr[i]
    // i = 0, 1, . . . , end
    // i am actually finding max length of subsequence ending with arr[]
    // driver
    public static void main1(String[] args) {
        // given an array
        int[] arr = new int[]{
                10, 22, 9, 33, 21, 50, 41, 60, 80
        };
        // make maxLength[]
        int[] maxLength = new int[arr.length];
        // make maxLength[0] = 1;
        maxLength[0] = 1;
        // find max of maxLength for else part
        int max = maxLength[0];
        // iterate over arr[] from 1
        for (int i = 1; i < arr.length; i++) {
            // if arr[] is greater to previous it will contribute to LIS
            if (arr[i - 1] < arr[i]) {
                // so make length[i] = just previous length + 1
                maxLength[i] = maxLength[i - 1] + 1;
            }

            // arr[] is smaller than previous
            // it will not contribute to LIS
            else {
                // maxLength will be the maximum of previous maxLength
                maxLength[i] = max;
            }
            // finding max in maxLength
            if (max < maxLength[i]) {
                max = maxLength[i];
            }
        }
        System.out.println(max);
    }
}