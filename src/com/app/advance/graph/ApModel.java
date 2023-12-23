package com.app.advance.graph;

public class ApModel {
    public int timer;
    public int par;
    public int[] dis;
    public int[] low;
    public boolean[] ap;

    public ApModel(int V) {
        this.timer=1;
        this.dis = new int[V];
        this.low = new int[V];
        this.ap = new boolean[V];
    }
}