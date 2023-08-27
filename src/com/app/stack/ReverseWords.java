package com.app.stack;

public class ReverseWords {
    //Function to reverse words in a given string.
    static String reverseWords(String S) {
        // code here
        String[] split = S.split("\\.");
        String[] split2 = new String[split.length];
        int j = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            split2[j++] = split[i];
        }
        return String.join(".", split2);


    }

    public static void main(String[] args) {
        reverseWords("as.pot");
    }
}