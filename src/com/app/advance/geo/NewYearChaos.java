package com.app.advance.geo;

import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int[] A = new int[q.size()];
        for (int i = 0; i < q.size(); i++) {
            A[i] = q.get(i);
        }

        int n = A.length;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] != (i + 1)) {
                if (((i - 1) >= 0) && A[i - 1] == (i + 1)) {
                    cnt++;
                    int temp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = temp;
                } else if (((i - 2) >= 0) && A[i - 2] == (i + 1)) {
                    cnt += 2;
                    A[i - 2] = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = i + 1;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println("cnt = " + cnt);


    }

    public static void main(String[] args) {
        //minimumBribes(List.of(2, 1, 5, 3, 4));
        //minimumBribes(List.of(2, 5, 1, 3, 4));
        minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4));
    }


}