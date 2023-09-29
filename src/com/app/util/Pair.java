package com.app.util;

import com.app.util.Node;

public class Pair {
    public Node node;
    public int hd;

    public Pair(Node n, int h) {
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