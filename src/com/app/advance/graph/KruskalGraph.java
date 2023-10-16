package com.app.advance.graph;

import com.app.util.Edge;

import java.util.ArrayList;
import java.util.List;

public class KruskalGraph {
    // Number of Vertices and Edges
    int V;
    List<Edge> edges;

    // Constructor of Graph class
    KruskalGraph(int V) {
        this.V = V;
        // Initializing list of edges.
        edges = new ArrayList<>();
    }

    // Function to add edges.
    void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

}