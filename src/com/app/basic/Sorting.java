package com.app.basic;

import java.util.*;

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

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            ans.add(list1.get(i++));
        }

        while (j < list2.size()) {
            ans.add(list2.get(j++));
        }
        return ans;
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


    void countingSort1(int[] arr) {

        int currMax = 0;
        int currMin = 100;
        for (int j : arr) {
            currMax = Math.max(currMax, j);
            currMin = Math.min(currMin, j);
        }

        int[] freq = new int[currMax - currMin + 1];

        for (int j : arr) {
            freq[j - currMin]++;
        }

        int[] lastPos = new int[freq.length];

        lastPos[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            lastPos[i] = lastPos[i - 1] + freq[i];
        }

        int[] ans = new int[arr.length];
        for (int item : arr) {
            ans[lastPos[item - currMin] - 1] = item;
            lastPos[item - currMin]--;
        }
        System.out.println("ans = " + Arrays.toString(ans));

    }

    String countingSortString(String str) {

        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 97]++;
        }

        int[] lastPos = new int[freq.length];

        lastPos[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            lastPos[i] = lastPos[i - 1] + freq[i];
        }

        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            lastPos[c - 97]--;
            stringBuilder.setCharAt(lastPos[c - 97], c);
        }

        System.out.println("stringBuilder = " + stringBuilder);
        return stringBuilder.toString();

    }


    int partition2(int[] arr, int start, int end) {
        int pivot = arr[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, end, j);

        return j;
    }

    void topoSortUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for (Integer nei : adj.get(src)) {
            if (!vis[nei]) {
                topoSortUtil(adj, nei, vis, st);
            }
        }
        st.add(src);
    }

    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSortUtil(adj, i, vis, stack);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    static int[] topoSortKahn(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] inDeg = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (Integer nei : list) {
                inDeg[nei]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            ans[i++] = polled;
            for (Integer nei : adj.get(polled)) {
                inDeg[nei]--;
                if (inDeg[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] arr = {20, 30, 80, 70};
        sorting.partition2(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }


}