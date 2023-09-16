package com.app.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {
    public static List<int[]> pairSum(int[] arr, int sum) {
        // Write your code here.
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(arr);
//        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    int[] temp = new int[arr.length];
                    temp[0] = arr[i];
                    temp[1] = arr[j];
                    list.add(temp);
//                    map.put(arr[i], arr[j]);
                }
            }
        }

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int[] temp = new int[arr.length];
//            temp[0] = entry.getKey();
//            temp[1] = entry.getValue();
//            list.add(temp);
//
//        }
        return list;

    }
}
