package com.app.basic.array;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RandomizedSet {
    Set<Integer> set;
    Random random;

    public RandomizedSet() {
        random = new Random();
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return random.nextInt(set.size());
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        boolean insert = randomizedSet.insert(2);// 2 was already in the set, so return false.
        System.out.println("insert = " + insert);

        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
