package com.app.linkedlist;

public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void addAtEnd(int k) {
        if (head == null) { // if list is empty
            head = new Node(k);
            return;
        }
        // if list is not empty
        // get hold of last node.
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // insert the node
        temp.next = new Node(k);
    }

    static void addAtGivenIndex(int k, int index) {
        Node temp;
        if (head == null || index == 1) {
            temp = head;
            head = new Node(k);
            head.next = temp;
            return;
        }
        int count = 1;
        temp = head;
        while (count != index && temp.next != null) {
            count++;
            temp = temp.next;
        }
        Node x = temp.next;
        temp.next = new Node(k);
        temp.next.next = x;
    }

    private static void traverse() {
        // copy head in temp
        Node temp = head;
        // iterate over the list
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // For this, we hold the previous node to be deleted and
    // will connect to node which is after the deleted node.
    static void deleteNodeAtGivenIndex(int index, int size) {
        // if list does not exist or size < index
        if (size < index || head == null) return;
        // if we want to delete at start
        if (index == 1) {
            head = head.next;
            return;
        }
        // if more than 1 node is there
        Node temp = head;
        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // iterative solution
    // we will traverse the list, and while traversing we keep changing pointers
    // using the current node and previous node.
    private static void reverse() {
        Node prev = null; // declaring previous of head
        Node current = head; // storing head in current
        while (current != null) { // traversing the list
            Node next = current.next; // getting hold of next of current
            current.next = prev; // making current next as previous
            prev = current; // new prev
            current = next; // new current
        }
        head = prev; // since curr is null so prev is head now
    }

    static class Main {
        public static void main(String[] args) {
            LinkedList.head = new Node(12);
            LinkedList.addAtEnd(34);
            LinkedList.addAtEnd(45);
            LinkedList.addAtEnd(78);
            LinkedList.traverse();
            LinkedList.reverse();
            LinkedList.traverse();
        }
    }
}