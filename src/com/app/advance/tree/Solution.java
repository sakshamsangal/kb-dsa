package com.app.advance.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    //Function to return the lowest common ancestor in a Binary Tree.
    boolean Path(Node root, int n, ArrayList<Node> p) {
        if (Objects.isNull(root)) {
            return false;
        }
        p.add(root);
        if (root.data == n) {
            return true;
        }
        boolean path1 = Path(root.left, n,p);
        if (path1) {
            return true;
        }
        boolean path2 = Path(root.right, n,p);
        if (path2) {
            return true;
        }
        p.remove(root);
        return false;
    }

    Node lca(Node root, int n1, int n2) {
        // Your code here
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        Path(root,n1,path1);
        Path(root,n2,path2);
        int size = Math.min(path1.size(), path2.size());
        for (int i = 0; i < size; i++) {
            if(path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
        }
        return null;
    }
}