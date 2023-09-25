package com.app.basic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Array {
    Map<Integer, Integer> getFrequencyFromArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer freq = map.getOrDefault(item, 0);
            map.put(item, freq + 1);
        }
        return map;
    }
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.'){
                int countOfSlash = 0;
                while (!stack.isEmpty() && countOfSlash != 2){
                    if (path.charAt(i) == '/') {
                        countOfSlash ++;
                    }
                    stack.pop();
                }
                stack.push('/');
            } else if (path.charAt(i) == '/'){
                if (!stack.isEmpty() &&stack.peek() != '/' && i != path.length()-1){
                    stack.push(path.charAt(i));
                }
            } else {
                stack.push(path.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : stack) {
            ans.append(character);
        }
        return ans.toString();
    }


    public boolean isAnagram(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }



    static void powerSet(int[] arr, int size) {
        int totalSubset = (int) Math.pow(2, size); // total set

        for (int i = 1; i < totalSubset; i++) {
            for (int j = 0; j < size; j++) {

                // which items to pick from arr = set bits from i
                if ((i & (1 << j)) > 0) { // go inside if bit is set
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3
        };
//        int i = kadaneAlgo(arr, arr.length);
        powerSet(arr, arr.length);
//        System.out.println("i = " + i);
    }

    // max element
    int getMaxElementIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
