package com.app.basic.stack;


import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> list;
    List<Integer> minList;

    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        if (minList.isEmpty() || top() < minList.get(minList.size() - 1)) {
            minList.add(val);
        } else {
            minList.add(minList.get(minList.size() -  1));
        }
    }

    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}