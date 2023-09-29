package com.app.advance.tree;

import com.app.util.Node;
import com.app.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class View {
    int levelSeen = 0;

    public void printLeft(Node root, int currLevel) {
        if (root == null)
            return;
        if (levelSeen < currLevel) {
            System.out.print(root.data + " ");
            levelSeen = currLevel;
        }
        printLeft(root.left, currLevel + 1);
        printLeft(root.right, currLevel + 1);
    }

    public void printLeftView(Node root) {
        printLeft(root, 1);
    }


    public void bv(Node root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            mp.put(hd, curr.data);
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

    public  void topView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (!mp.containsKey(hd))
                mp.put(hd, curr.data);
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

}
