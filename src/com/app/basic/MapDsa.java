package com.app.basic;

import java.util.*;

public class MapDsa {
    public int antiqueItems(int n, int items[], int price[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            int val = map.getOrDefault(items[i], price[i]);

            if (price[i] < val) {
                map.put(items[i], price[i]);
            }
        }

        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }
        return sum;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> setNums2 = new HashSet<>();
        for (int num : nums1) {
            setNums1.add(num);
        }

        for (int num : nums2) {
            setNums2.add(num);
        }


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Integer num : setNums1) {
            if (!setNums2.contains(num)) {
                list1.add(num);
            }
        }

        for (Integer num : setNums2) {
            if (!setNums1.contains(num)) {
                list2.add(num);
            }
        }
        return List.of(list1, list2);
    }

    Map<Integer, Integer> getFrequencyFromArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer freq = map.getOrDefault(item, 0);
            map.put(item, freq + 1);
        }
        return map;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

}
