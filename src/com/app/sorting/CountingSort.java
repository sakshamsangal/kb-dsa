package com.app.sorting;

import java.util.Arrays;

public class CountingSort {

    static void countingSort(int[] arr, int max) {
        int[] freq = new int[max + 1];
        int[] prefixSum = new int[max + 1];

        for (int item : arr) {
            freq[item]++;
        }

        prefixSum[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + freq[i];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int item = arr[i];
            out[prefixSum[item] - 1] = item;
            prefixSum[item]--;
        }
        System.out.println(Arrays.toString(out));
    }

    public static void main(String[] args) {

        int[] arr = {1, 7, 3, 6, 5, 6};
        countingSort(arr, 7);


    }
}