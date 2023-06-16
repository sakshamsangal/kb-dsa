package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    public static void topView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (!mp.containsKey(hd))
                mp.put(hd, curr.key);
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        topView(root);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int x) {
            key = x;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", hd=" + hd +
                    '}';
        }
    }
}