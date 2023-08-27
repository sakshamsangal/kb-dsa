package com.app.array;

public class Array {

    // 9
    // -2 1 -3 4 -1 2 1 -5 4
    // sub-array with maximum sum.
    // max sum that ends at ith index
    // e.g. index = 3
    // 4
    // -3 4
    // 1 -3 4
    // -2 1 -3 4
    // 1 2 3 4 5
    // choice 1: we can start a new sub-array
    // choice 2: add to existing sub-array

    private static int kadaneAlgo(int[] arr, int size) {
        int[] max = new int[size];
        max[0] = arr[0];
        int maximum = max[0];
        for (int i = 1; i < size; i++) {
            max[i] = Math.max(arr[i], arr[i] + max[i - 1]);
            if (maximum < max[i]) maximum = max[i];
        }
        return maximum;
    }



    static void powerSet(int[] arr, int size) {
        int totalSubset = (int) Math.pow(2, size); // total set

        for (int i = 1; i < totalSubset; i++) {
            for (int j = 0; j < size; j++) {

                if ((i & (1 << j)) > 0) { // go inside if bit is set
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }


    // max element
    int getMaxElementIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, -10,-2,12,80,-200
        };
        int i = kadaneAlgo(arr, arr.length);
        System.out.println("i = " + i);
    }

}
