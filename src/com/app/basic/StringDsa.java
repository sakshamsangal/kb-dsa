package com.app.basic;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringDsa {

    public String convert(String s, int numRows) {
//
//        for (int i = 0; i < s.length(); i=i+6) {
//            System.out.println("s.charAt(i) = " + s.charAt(i));
//        }
//
        for (int i = 1; i < s.length(); i=i+4) {
            System.out.println("s.charAt(i) = " + s.charAt(i));
        }

//        for (int i = 2; i < s.length(); i=i+4) {
//            System.out.println("s.charAt(i) = " + s.charAt(i));
//        }

        return s;
    }
    public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if (s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for (int idx = 0; idx < s.length(); idx++) {
            // Compare the maps, if not equal, return false...
            System.out.println("map1 = " + map1[s.charAt(idx)]);
            System.out.println("map2 = " + map2[t.charAt(idx)]);
            System.out.println();
            if (map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;

            // Insert each character if string s and t into separate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;

        }
        return true;    // Otherwise return true...
    }

//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Character> map = new HashMap<>();
//        HashSet<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != t.charAt(i)) {
//                    return false;
//                }
//            } else {
//                if (set.contains(t.charAt(i))){
//                    return false;
//                }
//                set.add(t.charAt(i));
//                map.put(s.charAt(i), t.charAt(i));
//            }
//
//        }
//        return true;
//    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // letter occurrence
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int j = ransomNote.charAt(i) - 97;
            if (arr[j] == 0) {
                return false;
            }
            arr[j]--;
        }
        return true;
    }


    public String reverseWords(String s) {
        int start = s.length() - 1;
        int end = start;
        StringBuilder stringBuilder = new StringBuilder();
        while (-1 < start) {
            // success
            while (s.charAt(end) == ' '){
                start--;
                end--;
            }

            while (s.charAt(start) != ' '){
                start--;
            }
            for (int i = start+1; i <= end; i++) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return s;
    }

    public String reverseWords2(String s) {
        String[] arr = s.trim().split("\\s+");
        String[] ans = new String[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            ans[j++] = arr[i];
        }
        return String.join(" ", ans);
    }

    public static void main(String[] args) {
        StringDsa stringDsa = new StringDsa();
        String s = stringDsa.convert("PAYPALISHIRING", 3);
        System.out.println("s = " + s);
    }
}
