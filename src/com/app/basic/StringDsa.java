package com.app.basic;

import java.util.Arrays;

public class StringDsa {
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

    public static void main(String[] args) {
        StringDsa stringDsa = new StringDsa();
        boolean b = stringDsa.canConstruct("aa", "aab");
        System.out.println("b = " + b);
    }
}
