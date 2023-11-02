package com.app.advance.graph;

import java.util.ArrayList;
import java.util.List;


class Graph {
    public List<List<Integer>> adj;
    public int size;

    public Graph(int size) {
        this.size = size;
        this.adj = new ArrayList<>(size);

        for (int i = 0; i < this.size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdgeSingleDirection(int u, int v) {
        adj.get(u).add(v);
    }

    void addEdgeBothDirection(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdgeSingleDirection(0, 1);
        graph.addEdgeSingleDirection(0, 2);
        graph.addEdgeSingleDirection(2, 3);
        graph.addEdgeSingleDirection(1, 3);
        graph.addEdgeSingleDirection(4, 5);
        graph.addEdgeSingleDirection(5, 6);
        graph.addEdgeSingleDirection(4, 6);

    }
}
