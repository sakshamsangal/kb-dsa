package com.app.basic.stack;


import java.util.*;

public class MinStack {
    List<Integer> stack;
    List<Integer> min;

    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (min.isEmpty() || val < min.get(min.size() - 1)) {
            min.add(val);
        }
    }

    public void pop() {
        int i = stack.size() - 1;
        int j = min.size() - 1;
        stack.remove(i);
        if (i == j) {
            min.remove(min.size()-1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }

    public static void main(String[] args) {
//        int[] arr = {11,15};
        MinStack obj = new MinStack();
        int[] arr = {0, 1, 1, 0, 0, 1, 0};
        int[] arr2 = {0, 5, 10, 15, 20, 25, 30};
    }
}
