package com.app.basic.array;// Java implementation of the approach

public class TWR2Pointer {

    static int maxWater(int[] arr, int n) {

        // Indices to traverse the array
        int start = 0;
        int end = n - 1;

        // To store Left max and end max
        // for two pointers leftPointer and end
        int m1 = 0;
        int m2 = 0;

        // To store the total amount
        // of rain water trapped
        int result = 0;
        while (start <= end) {

            // We need check for minimum of leftPointer
            // and end max for each element
            if (m1 <= m2) {
                // Add the difference between
                // current value and leftPointer max at index l
                result += Math.max(0, m1 - arr[start]);

                // Update leftPointer max
                m1 = Math.max(m1, arr[start]);

                // Update leftPointer pointer
                start += 1;
            } else {

                // Add the difference between
                // current value and end max at index r
                result += Math.max(0, m2 - arr[end]);

                // Update end max
                m2 = Math.max(m2, arr[end]);

                // Update end pointer
                end -= 1;

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
