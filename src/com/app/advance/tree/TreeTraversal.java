package com.app.advance.tree;

import com.app.util.Node;
import com.app.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
    public boolean inOrderWithSum(TreeNode root, int sum, int target) {
        if (root == null) {
            return target == sum;
        }
        if (inOrderWithSum(root.left, sum + root.val, target)) {
            return true;
        }
        return inOrderWithSum(root.right, sum + root.val, target);
    }

    public void printLevel(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public void printLevel2(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }

    public void inOrder(Node parent) {
        if (parent == null) {
            return;
        }
        inOrder(parent.left);
        System.out.print(parent.data + " ");
        inOrder(parent.right);
    }

    public void inOrder(List<Integer> ls, Node parent) {
        if (parent == null) {
            return;
        }
        inOrder(ls, parent.left);
        ls.add(parent.data);
        inOrder(ls, parent.right);
    }


    void bfs(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            // adding child of parents
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    public void printTreeInSpiralOrder(Node root) {
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
