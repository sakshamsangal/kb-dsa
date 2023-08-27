package com.app.stack;

import java.util.List;
import java.util.Stack;

public class SortStack {
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

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(50, 40, 30));
        sortStack(stack);
        System.out.println("stack = " + stack);

    }

}