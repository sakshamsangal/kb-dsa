package com.app.array;

public class Array {


    static void powerSet(int[] arr, int size) {
        int totalSubset = (int) Math.pow(2, size); // total set

        for (int i = 1; i < totalSubset; i++) {
            for (int j = 0; j < size; j++) {

                // which items to pick from arr = set bits from i
                if ((i & (1 << j)) > 0) { // go inside if bit is set
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3
        };
//        int i = kadaneAlgo(arr, arr.length);
        powerSet(arr, arr.length);
//        System.out.println("i = " + i);
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

}
