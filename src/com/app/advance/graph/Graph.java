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


    void addEdge1Way(int u, int v) {
        adj.get(u).add(v);
    }

    void addEdge2Way(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    void addEdge2Way(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge1Way(0, 1);
        graph.addEdge1Way(0, 2);
        graph.addEdge1Way(2, 3);
        graph.addEdge1Way(1, 3);
        graph.addEdge1Way(4, 5);
        graph.addEdge1Way(5, 6);
        graph.addEdge1Way(4, 6);

    }
}
