package com.app.advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

     void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int u : adj.get(s)) {
            if (!visited[u])
                dfs(adj, u, visited);
        }
    }

     void dfsForest(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(adj, i, visited);
        }
    }

    void bfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    void bfsForest(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bfs(adj, i, visited);
        }
    }


} 
