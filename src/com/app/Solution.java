package com.app;

public class Solution {

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {3, 1};
        int search = main.search(arr, 1);
        System.out.println("search = " + search);
    }
}

class Main {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return mid;

            // chances in which range target belongs to
            if (arr[start] < arr[mid]) {

                // 1st part is sorted
                // if target is in this range
                if (arr[start] <= target && target <= arr[mid]) {

                    // change end
                    end = mid - 1;
                }

                // may be target is in 2nd range
                else {
                    start = mid + 1;
                }
            }

            // 2nd part is sorted
            else {

                // check if target lies in this range
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                }

                // target not lie in sorted range
                else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }


}