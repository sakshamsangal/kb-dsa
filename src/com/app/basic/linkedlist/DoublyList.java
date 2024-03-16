package com.app.basic.linkedlist;

import com.app.util.DLLNode;

public class DoublyList {

    // Head and tail are the dummy nodes, to
    // implement the queue.
    DLLNode head, tail;

    public DoublyList() {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Function to add the node
    // next to the head of the List.
    public void addToHead(DLLNode node) {
        // Assigning the address of head
        // to node's previous pointer.
        node.prev = head;

        // Assigning the address of head's next
        // to node's next pointer.
        node.next = head.next;

        // Now making node to be head's next.
        head.next = node;

        // Then, make node's next's
        // previous to be node.
        node.next.prev = node;
    }

    // Function to remove the 'node' from the list.
    public void removeNode(DLLNode node) {
        // Changing address of previous and
        // next pointer.
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Function to move 'node' to head
    // of the List.
    public void moveToHead(DLLNode node) {
        // Remove it from it current position.
        removeNode(node);

        // Add it to head.
        addToHead(node);
    }

    // Function to remove node at
    // the tail of the List.
    public DLLNode removeFromTail() {
        // Store the result in 'ret'.
        DLLNode ret = tail.prev;
        // Remove 'ret'
        removeNode(ret);
        // Return 'ret'.
        return ret;
    }

}
