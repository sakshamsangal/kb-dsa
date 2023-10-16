package com.app.advance.graph;

import com.app.advance.dsu.DSU;
import com.app.util.Edge;

import java.util.Comparator;
import java.util.List;

public class MinSpanningTree {

    void myKruskalAlgo(int V, List<Edge> edges) {
        // Initializing e, i and sum with 0.
        int e = 0, i = 0, sum = 0;
        // Creating an object of DSU class.
        DSU dsu = new DSU(V);
        // Sorting edges using a custom comparator
        edges.sort(Comparator.comparingInt(e2 -> e2.weight));

        // Iterating till we include V-1 edges in MST
        while (e < V - 1) {
            Edge edge = edges.get(i++);

            int u = dsu.findParent(edge.u);
            int v = dsu.findParent(edge.v);
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

    public static void main(String[] args) {
        // Creating an object of Graph type.
        KruskalGraph g = new KruskalGraph(6);

        // Adding 9 edges to make the same
        // graph as given in examples.
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 8);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 6);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 4, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 2);

        // Calling the MST_Kruskal Function.
        MinSpanningTree minSpanningTree = new MinSpanningTree();
        minSpanningTree.myKruskalAlgo(g.V, g.edges);
    }
}
