package com.app.basic.stack;// Java implementation of the approach


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StackDsa {


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

    private static void maxLoss(int[] arr, int n) {

        int min = Integer.MAX_VALUE;
        int loss = 0;
        // curr=4  min=10
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            }
            int currLoss = Math.max(arr[i] - min, 0); // c=4,  min =2
            loss = Math.max(currLoss, loss);
        }
        System.out.println("loss = " + loss);


    }

    static String reverseWords(String S) {
        // code here
        String[] split = S.split("\\.");
        String[] split2 = new String[split.length];
        int j = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            split2[j++] = split[i];
        }
        return String.join(".", split2);


    }

    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        Integer item = stack.pop();
        sortStack(stack);
        if (stack.isEmpty() || stack.peek() <= item) {
            stack.add(item);
        } else {
            Stack<Integer> aux = new Stack<>();

            while (!stack.isEmpty() && item < stack.peek()) {
                aux.add(stack.pop());
            }
            stack.add(item);
            while (!aux.isEmpty()) {
                stack.add(aux.pop());
            }
        }
    }

    private static int stockBuySell(int[] price, int n) {

        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (price[i] < minSoFar) {
                minSoFar = price[i];
            }
            int diff = price[i] - minSoFar;
            if (maxProfit < diff) {
                maxProfit = diff;
            }
        }

        return maxProfit;
    }

    private static void solve(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        ans[0] = 1;
        stack.add(0);
        for (int i = 1; i < n; i++) {
            while (stack.peek() < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stack.peek();
            }
            stack.add(i);
        }
    }


    static int maxLength(String src) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int currMax = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    currMax = Math.max(currMax, i - stack.peek());
                }
            }
            System.out.println("stack = " + stack + "  currMax = " + currMax);
        }

        return currMax;
    }

    // Driver code
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;

        int i = maxLength("()()");
        System.out.println("i = " + i);
//        System.out.print(solve(price, n));
    }


}

