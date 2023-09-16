package com.app.advance.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalScalar {
    // Number of Vertices and Edges
    static int V, E;
    // List of Edge(s).
    static List<Edge> edges;

    // Constructor of Graph class
    KruskalScalar(int V, int E) {
        KruskalScalar.V = V;
        KruskalScalar.E = E;
        // Initializing list of edges.
        edges = new ArrayList<>();
    }

    // Function responsible to print MST.
    static void MST_Kruskal() {
        // Initializing e, i and sum with 0.
        int e = 0, i = 0, sum = 0;
        // Creating an object of DSU class.
        DSU dsu = new DSU(V);
        // Sorting edges using a custom comparator
        Collections.sort(edges,
                new Comparator<Edge>() {
                    public int compare(Edge e1, Edge e2) {
                        return e1.weight - e2.weight;
                    }
                }
        );

        // Iterating till we include V-1 edges in MST
        while (e < V - 1) {
            Edge edge = edges.get(i++);

            int u = dsu.find(edge.u);
            int v = dsu.find(edge.v);
            // Checking if adding edge with endpoints
            // u and v form a cycle.
            // If not
            if (u != v) {
                System.out.println("Adding edge " + edge.u + " <---> " + edge.v + " to MST");
                // Adding the weight of current edge to total
                // weight of the MST.
                sum += edge.weight;
                // Including the edge.
                dsu.union(u, v);
                // Increasing the edge count.
                e++;
            }
        }
        // Printing the total sum of the MST.
        System.out.println("MST has a weight of " + sum);
    }

    // Function to add edges.
    static void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public static void main(String[] args) {
        // Creating an object of Graph type.
        KruskalScalar g = new KruskalScalar(6, 9);

        // Adding 9 edges to make the same
        // graph as given in examples.
        addEdge(0, 1, 7);
        addEdge(0, 2, 8);
        addEdge(1, 2, 3);
        addEdge(1, 4, 6);
        addEdge(2, 3, 3);
        addEdge(2, 4, 4);
        addEdge(3, 4, 2);
        addEdge(3, 5, 2);
        addEdge(4, 5, 2);

        // Calling the MST_Kruskal Function.
        MST_Kruskal();
    }

    // Using DSU to quickly
    // tell whether adding edge
    // will form a cycle.
    static class DSU {

        // Declaring two arrays to hold
        // information about the parent and
        // rank of each node.
        private final int[] parent;
        private final int[] rank;

        // Constructor
        DSU(int n) {

            // Defining size of the arrays.
            parent = new int[n];
            rank = new int[n];

            // Initializing their values
            // with i's and 0s.
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find function
        public int find(int node) {

            // If the node is the parent of
            // itself then it is the leader
            // of the tree.
            if (node == parent[node]) return node;

            //Else, finding parent and also
            // compressing the paths.
            return parent[node] = find(parent[node]);
        }

        // Union function
        public void union(int u, int v) {

            // Make u as a leader
            // of its tree.
            u = find(u);

            // Make v as a leader
            // of its tree.
            v = find(v);

            // If u and v are not equal,
            // because if they are equal then
            // it means they are already in
            // same tree and it does not make
            // sense to perform union operation.
            if (u != v) {
                // Checking tree with
                // smaller depth/height.
                if (rank[u] < rank[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                // Attaching lower rank tree
                // to the higher one.
                parent[v] = u;

                // If now ranks are equal
                // increasing rank of u.
                if (rank[u] == rank[v])
                    rank[u]++;
            }
        }
    }

    // Edge class
    static class Edge {
        // Endpoints and weight of the edge.
        int u, v, weight;

        // Constructor
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}