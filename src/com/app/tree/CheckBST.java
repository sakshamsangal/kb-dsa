package com.app.tree;

public class CheckBST {

    static int prev = Integer.MIN_VALUE;
    static boolean isBST(Node root) {
        if (root == null)
            return true;
        if (!isBST(root.left)) return false;
        if (root.data<prev) return false;
        prev = root.data;
        return isBST(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(9);

        boolean bst = isBST(root);
        System.out.println("bst = " + bst);
    }


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int k) {
            data = k;
            left = right = null;
        }
    }
}