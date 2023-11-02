package com.app.advance.graph;

import java.util.List;

public class ArticulationPoint {
    static final int NIL = -1;
    int time = 0;


    public static void main(String[] args) {
        System.out.println("Articulation points in first graph ");
        Graph g = new Graph(5);
        g.addEdgeBothDirection(g.adj, 1, 0);
        g.addEdgeBothDirection(g.adj, 0, 2);
        g.addEdgeBothDirection(g.adj, 2, 1);
        g.addEdgeBothDirection(g.adj, 0, 3);
        g.addEdgeBothDirection(g.adj, 3, 4);

        ArticulationPoint articulationPoint = new ArticulationPoint();
        articulationPoint.AP(g.adj, g.size);
        System.out.println();
    }


    public void APUtil(List<List<Integer>> adj, int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {

        int children = 0;

        visited[u] = true;

        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(adj, v, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == NIL && children > 1)
                    ap[u] = true;

                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    public void AP(List<List<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];


        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(adj, i, visited, disc, low, parent, ap);

        for (int i = 0; i < V; i++)
            if (ap[i])
                System.out.print(i + " ");
    }
}
