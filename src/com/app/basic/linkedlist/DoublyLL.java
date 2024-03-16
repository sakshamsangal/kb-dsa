package com.app.basic.linkedlist;

import com.app.util.DLLNode;


public class DoublyLL {

    DLLNode head;
    DLLNode tail;

    public DoublyLL() {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addTail(DLLNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }


    public int removeHead() {
        DLLNode popped = head.next;
        deleteNode(head.next);
        return popped.key;
    }

    public void moveToTail(DLLNode node) {
        deleteNode(node);
        addTail(node);
    }

    public void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
