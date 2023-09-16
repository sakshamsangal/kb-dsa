package com.app.basic.array;// Java implementation of the approach

public class TWR2Pointer {

    static int maxWater(int[] arr, int n) {

        // Indices to traverse the array
        int leftPointer = 0;
        int rightPointer = n - 1;

        // To store Left max and rightPointer max
        // for two pointers leftPointer and rightPointer
        int l_max = 0;

        int r_max = 0;

        // To store the total amount
        // of rain water trapped
        int result = 0;
        while (leftPointer <= rightPointer) {

            // We need check for minimum of leftPointer
            // and rightPointer max for each element
            if (l_max <= r_max) {
                // Add the difference between
                // current value and leftPointer max at index l
                result += Math.max(0, l_max - arr[leftPointer]);

                // Update leftPointer max
                l_max = Math.max(l_max, arr[leftPointer]);

                // Update leftPointer pointer
                leftPointer += 1;
            } else {

                // Add the difference between
                // current value and rightPointer max at index r
                result += Math.max(0, r_max - arr[rightPointer]);

                // Update rightPointer max
                r_max = Math.max(r_max, arr[rightPointer]);

                // Update rightPointer pointer
                rightPointer -= 1;

            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int N = arr.length;
        System.out.print(maxWater(arr, N));
    }
}

// This code is contributed by rutvik_56.
