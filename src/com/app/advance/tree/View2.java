package com.app.advance.tree;

import com.app.util.HdPair;

import java.util.*;

public class View2 {

    public void printLeft(Node root, int currLevel) {

    }

    public void printLeftView(Node root) {
        printLeft(root, 1);
    }



    public ArrayList<Integer> bottomView(Node root) {
        Queue<HdPair> queue = new LinkedList<>();
        Map<Integer, Integer> hdMap = new TreeMap<>();

        queue.add(new HdPair(root, 0));
        while (!queue.isEmpty()) {
            HdPair hdPair = queue.poll();
            hdMap.put(hdPair.hd, hdPair.node.data);

            if (hdPair.node.left != null) {
                queue.add(new HdPair(hdPair.node.left, hdPair.hd - 1));
            }

            if (hdPair.node.right != null) {
                queue.add(new HdPair(hdPair.node.right, hdPair.hd + 1));
            }
        }
        return new ArrayList<>(hdMap.values());
    }


    public void topView(Node root) {

    }

}
