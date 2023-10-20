package com.app.advance.graph;

import java.util.ArrayList;
import java.util.List;


class Graph {
    private  List<List<Integer>> adj;
    private  int size;

    public Graph(int V) {
        size = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdgeSingleDirection(int u, int v) {
        adj.get(u).add(v);
    }

    void addEdgeByDirection(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdgeSingleDirection( 0, 1);
        graph.addEdgeSingleDirection( 0, 2);
        graph.addEdgeSingleDirection( 2, 3);
        graph.addEdgeSingleDirection( 1, 3);
        graph.addEdgeSingleDirection( 4, 5);
        graph.addEdgeSingleDirection( 5, 6);
        graph.addEdgeSingleDirection( 4, 6);

    }
}
