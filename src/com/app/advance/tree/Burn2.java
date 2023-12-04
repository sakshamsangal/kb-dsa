package com.app.advance.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Burn2 {

    static Node targetNode;
    static Map<Node, Node> map = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        int leaf = 50;
        int i = minTime(root, leaf);
        System.out.println("i = " + i);

    }

    public static Node inOrderTraversal(Node root, Node parent, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            targetNode = root;
        }
        inOrderTraversal(root.left, root, target);
        map.put(root, parent);
        inOrderTraversal(root.right, root, target);
        return root;
    }

    public static int minTime(Node root, int leaf) {
        inOrderTraversal(root, null, leaf);
        Queue<Node> queue = new LinkedList<>();

        queue.add(targetNode);
        visited.put(targetNode.data, true);

        int time = 0;
        while (!queue.isEmpty()) {
            boolean doesAnyNodeBurn = false;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node item = queue.poll();
                Node leftNode = item.left;
                Node rightNode = item.right;
                Node parentNode = map.get(item);

                if (leftNode != null && !visited.containsKey(leftNode.data)) {
                    visited.put(leftNode.data, true);
                    queue.add(leftNode);
                    doesAnyNodeBurn = true;
                }
                if (rightNode != null && !visited.containsKey(rightNode.data)) {
                    visited.put(rightNode.data, true);
                    queue.add(rightNode);
                    doesAnyNodeBurn = true;
                }

                if (parentNode != null && !visited.containsKey(parentNode.data)) {
                    visited.put(parentNode.data, true);
                    queue.add(parentNode);
                    doesAnyNodeBurn = true;
                }
            }
            if (doesAnyNodeBurn) {
                time++;
            }
        }
        map.clear();
        visited.clear();

        return time;
    }


}