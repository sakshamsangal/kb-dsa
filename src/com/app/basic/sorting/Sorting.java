package com.app.basic.sorting;

import java.util.Arrays;

public class Sorting {
    // insertionSort
    static void insertionSort(int[] arr, int size) {
        // for traversing array
        for (int i = 1; i < size; i++) {
            int item = arr[i];
            int end = i - 1;
            // for shifting array elements.
            while (-1 < end && item < arr[end]) {
                arr[end + 1] = arr[end--];
            }
            arr[end + 1] = item;
        }
    }

    // insertionSort
    static void insertionSort(String[] arr, int size) {
// for traversing array
        for (int i = 1; i < size; i++) {
            String item = arr[i];
            int end = i - 1;
            // for shifting array elements.
            while (-1 < end && item.compareTo(arr[end]) < 0) {
                arr[end + 1] = arr[end--];
            }
            arr[end + 1] = item;
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int x = 0;
        int y = 0;
        int k = start;
        int[] result = new int[end - start + 1];
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        // coping to left[] and right[] from arr[]
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[k++];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[k++];
        }
        k = 0;
        // merging 2 sorted arrays
        while (x < left.length && y < right.length) {
            result[k++] = left[x] < right[y] ? left[x++] : right[y++];
        }
        while (x < left.length) {
            result[k++] = left[x++];
        }
        while (y < right.length) {
            result[k++] = right[y++];
        }
        // coping to original array
        for (int i = 0; i < k; i++) {
            arr[start++] = result[i];
        }
    }

    // quickSort
    private static void quickSort(int[] arr, int start, int end) {
        // more than 1 element
        // sorting needs
        if (start < end) {
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int item = arr[start];
        int lastSmaller = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < item) {
                lastSmaller++;
                swap(arr, i, lastSmaller);
            }
        }
        swap(arr, lastSmaller, start);
        return lastSmaller;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = getMinIndex(arr, i);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private static int getMinIndex(int[] arr, int start) {
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) minIndex = i;
        }
        return minIndex;
    }


    static void countingSort(int[] arr, int max) {
        int[] rank = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            rank[arr[i]]++;
        }
        for (int i = 1; i < rank.length; i++) {
            rank[i] += rank[i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[rank[arr[i]] - 1] = arr[i];
            rank[arr[i]]--;
        }
        System.out.println(Arrays.toString(result));
    }
}