package com.app.advance.graph;

import com.app.advance.dsu.DSU;
import com.app.util.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {

    static int spanningTree(int V, int E, int ed[][]) {

        List<Edge> edges = new ArrayList<>();
        for (int[] row : ed) {
            edges.add(new Edge(row[0], row[1], row[2]));
        }

        DSU dsu = new DSU(V);

        int sum = 0;
        int count = 0;
        edges.sort(Comparator.comparingInt(value -> value.weight));
        for (Edge edge : edges) {
            if (count == V - 1) {
                break;
            }

            int p1 = dsu.findParent(edge.u);
            int p2 = dsu.findParent(edge.v);


            if (p1 != p2) {
                sum += edge.weight;
                dsu.union(p1, p2);
                count++;
            }
        }

        return sum;

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

        KruskalAlgo minSpanningTree = new KruskalAlgo();
    }
}
