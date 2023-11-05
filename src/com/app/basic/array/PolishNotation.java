package com.app.basic.array;

import java.util.Stack;

public class PolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int num1;
        int num2;
        for (String token : tokens) {
            // push in stack when there is number

            if (token.equals("+")) {
                // remove 2 items from stack to perform operation
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (token.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (token.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (token.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        PolishNotation polishNotation = new PolishNotation();
        int i = polishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println("i = " + i);
    }
}