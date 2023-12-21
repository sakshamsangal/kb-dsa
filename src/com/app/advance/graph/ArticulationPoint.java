package com.app.advance.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    static final int NIL = -1;
    int time = 0;


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

                if (parent[u] == NIL && children > 1) {
                    ap[u] = true;
                }

                if (parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }

            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
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


    public ArrayList<Integer> articulationPoints(int V, List<List<Integer>> adj) {

        boolean[] vis = new boolean[V];
        ApModel apModel = new ApModel(V);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                apModel.par = -1;
                articulationPointsUtil(adj, i, vis, apModel);
            }
        }

        ArrayList<Integer> ap = new ArrayList<>();
        for (int i = 0; i < apModel.ap.length; i++) {
            if (apModel.ap[i]) {
                ap.add(i);
            }
        }
        if (ap.size() == 0) {
            return (ArrayList<Integer>) List.of(-1);
        }
        return ap;
    }

    public void articulationPointsUtil(List<List<Integer>> adj, int src, boolean[] vis, ApModel apModel) {
        vis[src] = true;
        apModel.dis[src] = apModel.timer;
        apModel.low[src] = apModel.timer;

        int child = 0;
        for (Integer nei : adj.get(src)) {
            if (!vis[nei]) {
                child++;
                apModel.par = nei;
                apModel.timer = apModel.timer + 1;
                articulationPointsUtil(adj, nei, vis, apModel);

                apModel.low[src] = Math.min(apModel.low[src], apModel.low[nei]);
                if (apModel.dis[src] <= apModel.low[nei]) {
                    apModel.ap[src] = true;
                }

            } else if (nei != apModel.par) {
                apModel.low[src] = Math.min(apModel.low[src], apModel.dis[nei]);
            }
        }
        if (apModel.par == -1 && 1 < child) {
            apModel.ap[src] = true;
        }
    }


    public static void main(String[] args) {
        ArticulationPoint articulationPoint = new ArticulationPoint();

        Graph graph = new Graph(5);
        graph.addEdge2Way(0, 1);
        graph.addEdge2Way(1, 4);
        graph.addEdge2Way(2, 4);
        graph.addEdge2Way(3, 4);
        graph.addEdge2Way(2, 3);

        ArrayList<Integer> integers = articulationPoint.articulationPoints(graph.size, graph.adj);
        System.out.println("integers = " + integers);
    }


}
