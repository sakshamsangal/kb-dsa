package com.app.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueDsa {

    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> queueWithRev = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty() && k != 0) {
            stack.add(q.poll());
            k--;
        }
        while (!stack.isEmpty()) {
            queueWithRev.add(stack.pop());
        }
        while (!q.isEmpty()){
            queueWithRev.add(q.poll());
        }
        return queueWithRev;
    }

    public static void main(String[] args) {

    }
}
