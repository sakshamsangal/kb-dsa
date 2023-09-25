package com.app.basic.search;

import java.util.ArrayList;
import java.util.List;

public class Search {
    static int count = 1;

    public int getPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if (arr[start] <= arr[end]) return -1;
        while (start < end) {
            int mid = (start + end) / 2;

            // mid is in 1st array
            if (arr[0] <= arr[mid]) {
                start = mid + 1;
            }

            // mid is in 2nd array
            else {
                end = mid;
            }
        }
        return start;
    }

    int binarySearch2(int start, int end, int num) {
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long item = (long) mid * mid;
            if (item == num) return mid;
            if (item < num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }


    public int mySqrt(int num) {
        return binarySearch2(0, num, num);
    }

    public int searchRotatedArray(int[] arr, int target) {
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

    int searchInsert(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int eq = 0;
        for (int num : nums) {
            if (num < target) smaller++;
            else if (num == target) eq++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < eq; i++) {
            list.add(smaller);
            smaller++;
        }
        return list;
    }

    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 == -1) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            }

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int findMin(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) return arr[start];
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[0] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // normal binary search program
    static int binarySearch(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static boolean binarySearch2(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == item) {
                return true;
            }
            if (item < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    class Pair {
        int ceil;
        int floor;

        public Pair() {
        }

        public Pair(int ceil, int floor) {
            this.ceil = ceil;
            this.floor = floor;
        }

        public int getCeil() {
            return ceil;
        }

        public void setCeil(int ceil) {
            this.ceil = ceil;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }
    }

    public Pair ceilFloor(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;

        Pair pair = new Pair(-1,-1);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // hit
            if (arr[mid] == item) {
                pair.ceil = arr[mid];
                pair.floor = arr[mid];
                return pair;
            }

            // miss
            if (item < arr[mid]) {
                pair.ceil = arr[mid];
                end = mid - 1;
            } else {
                pair.floor = arr[mid];
                start = mid + 1;
            }
        }
        return pair;
    }


    public int getStrictCeilIndex(char[] arr, char item) {
        int ceil = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // miss
            if (item < arr[mid]) {
                ceil = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceil;
    }

    // when arr.length is not allowed
    static boolean binarySearchInfinityArray(int[] arr, int item) {
        Bound.setBound(arr, item);
        int start = Bound.lower;
        int end = Bound.upper;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == item) return true;
            if (item < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    static boolean linearSearch(int[] arr, int key) {
        for (Integer item : arr) {
            if (item == key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Search.binarySearch2(arr, arr[i]);
            System.out.println(arr[i] + " = " + Search.count);
            sum += Search.count;
            Search.count = 1;
        }
        System.out.println("Total comparison = " + sum / arr.length);
    }

    static class Bound {
        static int lower = 0;
        static int upper = 2;

        public static void setBound(int[] arr, int item) {
            while (arr[upper] < item) {
                lower = upper;
                upper <<= 1;
            }
        }
    }
    // // reverse order
    // static int linearSearch(int[] arr, int key) {
    //     for (int i = arr.length - 1; i > -1; i--) {
    //         if (arr[i] == key) return arr.length - 1 - i;
    //     }
    //     return -1;
    // }
    //
    // // reverse traversal
    // static boolean linearSearch(int[] arr, int key) {
    //     for(int i = arr.length - 1; i > -1; i--) {
    //         if (arr[i] == key) return true;
    //     }
    //     return false;
    // }
}



