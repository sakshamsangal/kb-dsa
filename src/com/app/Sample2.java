package com.app;


import java.util.Arrays;

class Sample6_25_24 {

    public int[] findOrder(int length, int[][] arr) {
        return new int[0];
    }
}


public class Sample2 {

    public static void main(String[] args) {
        Sample6_25_24 main = new Sample6_25_24();
        int[][] arr = {{1,0},{0,1}};
        // int[] arr = {1, 1, 1};
        int[] order = main.findOrder(arr.length, arr);
        System.out.println("order = " + Arrays.toString(order));
    }
}
