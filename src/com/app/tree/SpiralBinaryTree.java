package com.app.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class SpiralBinaryTree {
    class Node {
        Node left;
        int data;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    Node root;
    public SpiralBinaryTree(Node root) {
        this.root = root;
    }
    public void printTreeInSpiralOrder() {
    Queue<Node> queue = new LinkedList<>();
    Stack<Node> stack = new Stack<>();
    int count = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
        int x = queue.size();
        for (int i = 0; i < x; i++) {
            Node deleted = queue.poll();
            if (count % 2 != 0) {
                // store the result in to the stack
                stack.add(deleted);
            } else {
                // i want to print on to the console.
                System.out.print(deleted.data + " ");
            }
            if (deleted.left != null) queue.add(deleted.left);
            if (deleted.right != null) queue.add(deleted.right);
        }
        if (count % 2 != 0) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
            }
        }
        count++;
    }
}
}