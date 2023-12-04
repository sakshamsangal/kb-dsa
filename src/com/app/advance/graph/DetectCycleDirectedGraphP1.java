package com.app.advance.graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraphP1 {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
        visited[s] = true;
        recSt[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u] && DFSRec(adj, u, visited, recSt)) {
                return true;
            } else if (recSt[u]) {
                return true;
            }
        }
        recSt[s] = false;
        return false;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        boolean[] recSt = new boolean[V];
        for (int i = 0; i < V; i++)
            recSt[i] = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (DFSRec(adj, i, visited, recSt))
                    return true;
        }
        return false;
    }


    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, boolean[] recTrack) {
        vis[src]=true;
        recTrack[src] = true;

        for (Integer child : adj.get(src)) {
            if (vis[child]) {
                if (recTrack[child]){
                    return true;
                }
                continue;
            }
            if (dfs(adj, child, vis, recTrack)) {
                return true;
            }

        }
        recTrack[src] = false;
        return false;
    }





    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] recTrack = new boolean[V];


         for (int i = 0; i < V; i++) {
             if (vis[i]) {
                continue;
             }
             if (dfs(adj, 0, vis,recTrack)) {
                 return true;
             }
         }

        return false;
    }


}


