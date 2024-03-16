package com.app.basic.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDsa {

    Node head;

    public LinkedListDsa(int head) {
        this.head = new Node(head);
    }

    public void addLast(int k) {
        if (head == null) { // if list is empty
            head = new Node(k);
            return;
        }

        // if list is not empty
        // get hold of last node.
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // insert the node
        curr.next = new Node(k);
    }


    public void traverse(Node head) {
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        System.out.println("list = " + list);
    }


    public static void main(String[] args) {

        LinkedListDsa ll = new LinkedListDsa(10);
        ll.addLast(20);
        ll.addLast(30);
    }
}