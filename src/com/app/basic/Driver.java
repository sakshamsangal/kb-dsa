package com.app.basic;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Driver {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime pastDate = LocalDateTime.parse("2017-01-14T15:32:56.000");
//        LocalDateTime pastDate = LocalDateTime.now();
        boolean isBefore = now.isBefore(pastDate);	//false
        System.out.println("isBefore = " + isBefore);

        boolean isAfter = now.isAfter(pastDate);	//true
        System.out.println("isAfter = " + isAfter);


        boolean isEqual = now.isEqual(pastDate);	//false20

        System.out.println("isEqual = " + isEqual);
//        System.out.println((int)'z');
    }
}
