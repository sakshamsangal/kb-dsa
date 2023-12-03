package com.app.basic.array;

import com.app.basic.linkedlist.DoublyList;
import com.app.util.DLLNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class LRUCache {

    // Size denotes the current size of
    // the List while capacity is the
    // maximum size list is allowed to take.
    int capacity;

    // 'map' is the Hash that will map
    // the 'key' to 'Nodes'.

    public Map<Integer, DLLNode> map;

    DoublyList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoublyList();
        map = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = map.get(key);
        if (Objects.isNull(node)) {

            System.out.println("-1 = ");
            return -1;
        }
        list.moveToHead(node);
        System.out.println("node.val = " + node.val);
        return node.val;
    }

    public void put(int key, int value) {

        DLLNode node = map.get(key);
        if (Objects.isNull(node)) {
            if (map.size() == capacity) {
                DLLNode popped = list.removeFromTail();
                map.remove(popped.key);
            }

            DLLNode item = new DLLNode(key, value);
            list.addToHead(item);
            map.put(key, item);
        } else {
            node.val = value;
            list.moveToHead(node);
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);    // return 1
        lRUCache.put(2, 6); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(1);    // returns -1 (not found)

        lRUCache.put(1, 5); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.put(1, 2); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(2);    // return 3
    }
}
