package com.app.number_theory;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        int q = numerator / denominator;
        int r = numerator % denominator;

        StringBuilder ans = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        ans.append(q);
        if (r == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            while (r != 0) {
                if (map.containsKey(r)) {
                    Integer i = map.get(r);
                    ans.insert(i, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r, ans.length());
                    numerator = r * 10;
                    q = numerator / denominator;
                    r = numerator % denominator;
                    ans.append(q);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = fractionToDecimal(4, 333);
        System.out.println("s = " + s);
    }
}