package com.app;

public class Solution {

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1, 2};

        long startTime = System.currentTimeMillis();
       main.firstBadVersion(100);
        long stopTime = System.currentTimeMillis();
        long timeTaken = stopTime - startTime;
        System.out.println("timeTaken = " + timeTaken);



        startTime = System.currentTimeMillis();
        main.firstBadVersion2(100);
        stopTime = System.currentTimeMillis();

        timeTaken = stopTime - startTime;
        System.out.println("timeTaken = " + timeTaken);



    }


}

class Main {
    boolean isBadVersion(int version) {
        if (version < 25) {
            return false;
        }
        return true;
    }

    public int firstBadVersion2(int n) {
        int i = 0;
        int j = n;
        int ans = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            boolean badVersion = isBadVersion(mid-1);
            System.out.println("mid = " + mid);
            if (isBadVersion(mid)) {
                ans = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }


        return ans;
    }

    public int firstBadVersion(int n) {

        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid = " + mid);

            boolean badVersion = isBadVersion(mid);
            // success
            if (!isBadVersion(mid - 1) && badVersion) {
                return mid;
            }

            // shift domain
            // good version
            // remove left
            if (!badVersion) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}