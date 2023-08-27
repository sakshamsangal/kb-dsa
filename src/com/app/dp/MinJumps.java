package com.app.dp;

public class MinJumps {

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 1, 2, 1};
        int ans = getMinJumps(arr, arr.length - 1);
        System.out.println("ans = " + ans);

    }

    private static int getMinJumps(int[] arr, int end) {
        if (end == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < end; i++) {
            if (arr[i] + i >= end) {
                int minJumps = getMinJumps(arr, i); // potential ans
                if (minJumps != Integer.MAX_VALUE){
                    ans = Math.min(minJumps + 1, ans);
                }
            }
        }
        return ans;
    }

}