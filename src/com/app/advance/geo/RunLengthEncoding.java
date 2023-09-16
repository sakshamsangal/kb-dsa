package com.app.advance.geo;

public class RunLengthEncoding {
    public static void solve(String str) {
        int[] arr = new int[str.length()];
        char ch = str.charAt(0);
        int prev = 1;
        int i;
        for (i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                prev += 1;
            } else {
                System.out.println("ch = " + ch);
                System.out.println(prev);
                prev = 1;
                ch = str.charAt(i);
            }

        }

        if (i == str.length() - 1) {
            System.out.println("ch = " + ch);
            System.out.println(prev);
        }
    }

    public static void main(String[] args) {
        solve("aaabbbccc");
        //minimumBribes(List.of(2, 1, 5, 3, 4));
        //minimumBribes(List.of(2, 5, 1, 3, 4));
//        minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4));
    }


}