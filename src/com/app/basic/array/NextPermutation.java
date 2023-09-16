package com.app.basic.array;

import java.util.ArrayList;

public class NextPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        int len = permutation.size();
        if (1 < len) {

            // Write your code here.
            Integer a = permutation.remove(len - 1);
            Integer b = permutation.remove(len - 2);
            permutation.add(a);
            permutation.add(b);
        }

        return permutation;
    }
}
