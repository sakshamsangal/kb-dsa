package com.app.advance.tree;

import com.app.util.Node;

import java.util.*;

public class Burn {

    static Node srcNode;
    static Map<Node, Node> map = new HashMap<>();
    static Map<Node, Boolean> visited = new HashMap<>();



    public static void storeParent(Node root, Node parent, Node src) {
        if (Objects.isNull(root)) {
            return;
        }
        storeParent(root.left, root, src);

        if (root.data == src.data) {
            srcNode = root;
        }

        map.put(root, parent);
        storeParent(root.right, root, src);
    }

    public static int minTime(Node root, int target) {
        Node src = new Node(target);

        storeParent(root, null, src);


        // processed nodes
        Queue<Node> queue = new LinkedList<>();

        visited.put(srcNode, true);
        queue.add(srcNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burn = false;
            for (int i = 0; i < size; i++) {
                Node poll = queue.remove();
                Node parent = map.get(poll);

                if (Objects.nonNull(poll.left) && !visited.getOrDefault(poll.left, false)) {
                    visited.put(poll.left, true);
                    queue.add(poll.left);
                    burn = true;
                }

                if (Objects.nonNull(poll.right) && !visited.getOrDefault(poll.right, false)) {
                    visited.put(poll.right, true);
                    queue.add(poll.right);
                    burn = true;
                }

                if (Objects.nonNull(parent) && !visited.getOrDefault(parent, false)) {
                    visited.put(parent, true);
                    queue.add(parent);
                    burn = true;
                }
            }
            if (burn) {
                time++;
            }

        }
        map.clear();
        visited.clear();

        return time;
    }

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
}