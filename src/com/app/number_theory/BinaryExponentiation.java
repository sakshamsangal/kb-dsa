package com.app.number_theory;

public class BinaryExponentiation {
    private static int power(int base, int power) {
        int result = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                power--;
                result *= base;
            }
            // we have even power now
            power = power >> 1; // divide by 2
            base *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = power(3, 4);
        System.out.println("i = " + i);
    }
}