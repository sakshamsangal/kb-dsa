package com.app.advance.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v])
                DFS(adj, v, st, visited);
        }
        st.push(u);
    }


    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                DFS(adj, u, st, visited);
            }
        }

        while (!st.empty())
            System.out.print(st.pop() + " ");

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);

        System.out.println("Following is a Topological Sort of");
        topologicalSort(adj, V);
    }

}
