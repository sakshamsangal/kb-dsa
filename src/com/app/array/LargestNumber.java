package com.app.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
//        String[] str = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//        List<String> collect = Arrays.stream(nums).mapToObj(String::valueOf).toList();
        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (str[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String s : str) {
            ans.append(s);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = largestNumber(new int[]{10, 30, 20});
        System.out.println("s = " + s);
    }
}
