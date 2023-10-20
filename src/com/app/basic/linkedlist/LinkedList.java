package com.app.basic.linkedlist;

import com.app.util.ListNode;

public class LinkedList {
    ListNode head;

    void append(int k) {
        if (head == null) { // if list is empty
            head = new ListNode(k);
            return;
        }
        // if list is not empty
        // get hold of last node.
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // insert the node
        temp.next = new ListNode(k);
    }

    void addAtGivenIndex(int k, int index) {
        ListNode temp;
        if (head == null || index == 1) {
            temp = head;
            head = new ListNode(k);
            head.next = temp;
            return;
        }
        int count = 1;
        temp = head;
        while (count != index && temp.next != null) {
            count++;
            temp = temp.next;
        }
        ListNode x = temp.next;
        temp.next = new ListNode(k);
        temp.next.next = x;
    }

    void traverse() {
        // copy head in temp
        ListNode temp = head;
        // iterate over the list
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // For this, we hold the previous node to be deleted and
    // will connect to node which is after the deleted node.
    void deleteNodeAtGivenIndex(int index, int size) {
        // if list does not exist or size < index
        if (size < index || head == null) return;
        // if we want to delete at start
        if (index == 1) {
            head = head.next;
            return;
        }
        // if more than 1 node is there
        ListNode temp = head;
        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // iterative solution
    // we will traverse the list, and while traversing we keep changing pointers
    // using the current node and previous node.
    private void reverse() {
        ListNode prev = null; // declaring previous of head
        ListNode current = head; // storing head in current
        while (current != null) { // traversing the list
            ListNode next = current.next; // getting hold of next of current
            current.next = prev; // making current next as previous
            prev = current; // new prev
            current = next; // new current
        }
        head = prev; // since curr is null so prev is head now
    }


    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;

        ListNode list1 = new ListNode(-1);
        ListNode list2 = new ListNode(-1);

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next=null;

            if (curr.val < x) {
                p1.next = curr;
                p1 = curr;
            } else {
                p2.next = curr;
                p2 = curr;
            }
            curr = next;
        }
        p1.next = list2.next;
        head = list1.next;
        return head;

    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(1);

        linkedList.head = linkedList.partition(linkedList.head, 2);
        linkedList.traverse();
    }
}