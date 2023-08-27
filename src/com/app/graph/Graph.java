package com.app.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Graph {

    private static ArrayList<ArrayList<Integer>> adj;
    private static int size;

    public Graph(int V) {
        size = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < size; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        // adj.get(v).add(u);
    }


    void BFSConnected(int s, boolean[] visited) {
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

    void BFSDisconnected() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                BFSConnected(i, visited);
            }
        }
    }

    void DFSRec(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                DFSRec(u, visited);
            }
        }
    }

    void DFSConnected(int s) {
        boolean[] visited = new boolean[size];
        DFSRec(s, visited);
    }

    void DFSDisconnected() {
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                DFSRec(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

//        g.BFSConnected(2, new boolean[4]);
//        g.DFSConnected(2);
        g.DFSDisconnected();
    }
}
