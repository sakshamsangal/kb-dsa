package com.app.advance.graph;

import java.util.*;
import java.util.stream.IntStream;

public class Dijkstra {
    private final int V;
    private final List<List<Edge>> adj;

    Dijkstra(int V) {
        this.V = V;
        adj = new ArrayList<>();
        IntStream.range(0, V).forEach(i -> adj.add(new ArrayList<>()));
    }

    static int[] dijkstra1(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.d));
        int[] currDis = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(currDis, Integer.MAX_VALUE);

        pq.add(new Pair(S, 0));
        currDis[S] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().key;
            visited[u] = true;
            for (ArrayList<Integer> item : adj.get(u)) {
                if (!visited[item.get(0)] && currDis[item.get(0)] > currDis[u] + item.get(1)) {
                    currDis[item.get(0)] = currDis[u] + item.get(1);
                    pq.add(new Pair(item.get(0), currDis[item.get(0)]));
                }
            }
        }

        return currDis;
    }


    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        int[] disFromSrc = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(disFromSrc, Integer.MAX_VALUE);
        disFromSrc[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
        vis[src] = true;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair parent = pq.poll();

            for (ArrayList<Integer> child : adj.get(parent.key)) {
                if (vis[child.get(0)]) {
                    continue;
                }
                Integer parToChildDis = child.get(1);
                if (disFromSrc[child.get(0)] > disFromSrc[parent.key] + parToChildDis) {
                    disFromSrc[child.get(0)] = disFromSrc[parent.key] + parToChildDis;
                    vis[child.get(0)] = true;
                    pq.add(new Pair(child.get(0), disFromSrc[child.get(0)]));
                }
            }
        }

        return disFromSrc;
    }


    public static void main(String[] args) {
        int V = 9;
        Dijkstra g = new Dijkstra(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(u, v, weight));
        adj.get(v).add(new Edge(v, u, weight));
    }


    void shortestPath(int src) {
//        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.d));
        int[] currDis = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(currDis, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0));
        currDis[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().key;
            visited[u] = true;
            for (Edge edge : adj.get(u)) {
                if (!visited[edge.v] && currDis[edge.v] > currDis[u] + edge.w) {
                    currDis[edge.v] = currDis[u] + edge.w;
                    pq.add(new Pair(edge.v, currDis[edge.v]));
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + currDis[i]);
        }
    }

    // Edge class
    static class Edge {
        // Endpoints and weight of the edge.
        int u, v, w;

        // Constructor
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Pair {
        int key;
        int d;

        public Pair(int key, int d) {
            this.key = key;
            this.d = d;
        }
    }
}
