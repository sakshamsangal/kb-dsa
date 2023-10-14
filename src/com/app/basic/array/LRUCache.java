package com.app.basic.array;

import com.app.basic.linkedlist.DoublyList;
import com.app.util.DLLNode;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {

    // Size denotes the current size of
    // the List while capacity is the
    // maximum size list is allowed to take.
    int size, capacity;


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
        // Checking in the 'map' for check
        // the 'node' with Key as 'key'.
        DLLNode node = map.get(key);

        // If no such node exists in 'map'
        // Return -1.
        if (node == null)
            return -1;

        /// Otherwise move it to the head.
        list.moveToHead(node);

        // Returning the value associated with 'node'.
        return node.val;
    }

    public void put(int key, int value) {
        // Checking if map allowed co
        DLLNode node = map.get(key);

        // If it do not exists.
        if (node == null) {
            // Defining a new node that will be
            // inserted in the cache.
            DLLNode newNode = new DLLNode(key, value);
            // Putting in 'map'.
            map.put(key, newNode);
            // Adding it to head of list.
            list.addNode(newNode);

            // Increasing the size of the list.
            size++;

            // If after adding, 'size' exceeds the
            // capacity.
            if (size > capacity) {
                // Remove the node at tail, because
                // it is the least recently used.
                DLLNode temp = list.popTail();
                map.remove(temp.key);

                // Reducing the size by 1.
                size--;
            }
        }
        // Otherwise if it exists.
        else {
            // Update the value.
            node.val = value;

            // Move the node to head of the list.
            list.moveToHead(node);
        }
    }
}
