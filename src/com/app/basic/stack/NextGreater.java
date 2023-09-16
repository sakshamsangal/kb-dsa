package com.app.basic.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreater {

    public static ArrayList<Integer> nextGreater(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[n - 1]);
        ans.add(-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            int ng = stack.isEmpty() ? -1 : stack.peek();
            ans.add(ng);
            stack.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

//        int[] arr = new int[]{5, 15, 10, 8, 6, 12, 9, 18};

//        int[] arr = new int[]{20, 30, 10, 5, 15};
//        int[] arr = new int[]{20, 30, 40, 50, 60};
        int[] arr = new int[]{50, 40, 30, 20, 10};
        for (int x : nextGreater(arr, arr.length)) {
            System.out.print(x + " ");
        }

    }

}