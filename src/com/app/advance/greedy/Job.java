package com.app.advance.greedy;

public class Job {
    public int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    public Job() {
    }

    public int getId() {
        return id;
    }

    public int getProfit() {
        return profit;
    }

    public int getDeadline() {
        return deadline;
    }
}
