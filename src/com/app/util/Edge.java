package com.app.util;

public class Edge {
    // Endpoints and weight of the edge.
    public int u;
    public int v;
    public int weight;

    // Constructor
    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}