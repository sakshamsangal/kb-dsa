package com.app.basic.stack;

import java.util.Arrays;
import java.util.Stack;

public class PrevGreater {

    public static void printPrevGreater2(int[] arr, int n) {

        int[] ans = new int[n];
        ans[0] = -1;

        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.add(arr[i]);

        }

        System.out.println("ans = " + Arrays.toString(ans));


    }


    public static void printPrevGreater(int[] arr, int n) {

        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);
        for (int i = 0; i < n; i++) {

            // remove smaller items from stack
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            int pg = s.isEmpty() ? -1 : s.peek();
            System.out.print(pg + " ");

            s.add(arr[i]);
        }
    }

    public static void main(String[] args) {

//        int[] arr = new int[]{20, 30, 10, 5, 15};
//        int[] arr = new int[]{20, 30, 40, 50, 60};
        int[] arr = new int[]{50, 40, 30, 20, 10};

        printPrevGreater(arr, arr.length);
        printPrevGreater2(arr, arr.length);

    }

}