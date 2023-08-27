package com.app.stack;

import java.util.Stack;

public class PrevGreater {

    public static void printPrevGreater(int[] arr, int n) {

        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && s.peek() <= arr[i])
                s.pop();
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

    }

}