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

    public void findCircleNumUtil(int[][] isConnected, int src, boolean[] vis) {
        vis[src] = true;
        for (int i = 0; i < isConnected[src].length; i++) {
            if (isConnected[src][i] == 1 && !vis[i]) {
                findCircleNumUtil(isConnected, i, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] vis = new boolean[isConnected.length];
        int provinceCount = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                findCircleNumUtil(isConnected, i, vis);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    public static void main(String[] args) {
        GraphTraversal graphTraversal = new GraphTraversal();
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = graphTraversal.findCircleNum(arr);
        System.out.println("circleNum = " + circleNum);
    }
} 
