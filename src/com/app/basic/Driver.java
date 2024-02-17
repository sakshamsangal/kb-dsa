package com.app.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Driver {
    public static void main(String[] args) {

        UUID uuid1 = UUID.fromString("7c7258d5-19b3-40c0-9b56-b99f8c97ebc3");
        UUID uuid2 = UUID.fromString("7c7258d5-19b3-40c0-9b56-b99f8c97ebc4");
        HashSet<UUID> set = new HashSet<>();
        set.add(uuid1);
        set.add(uuid2);
        System.out.println("set = " + set);
//        System.out.println((int)'z');
    }
}
