package com.app.advance.tree;

public class LeftView {


    static int levelSeen = 0;

    public static void printLeft(Node root, int currLevel) {
        if (root == null)
            return;
        if (levelSeen < currLevel) {
            System.out.print(root.key + " ");
            levelSeen = currLevel;
        }
        printLeft(root.left, currLevel + 1);
        printLeft(root.right, currLevel + 1);
    }

    public static void printLeftView(Node root) {
        printLeft(root, 1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        printLeftView(root);
    }

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }

}