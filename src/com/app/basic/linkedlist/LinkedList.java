package com.app.basic.linkedlist;

import com.app.util.ListNode;

public class LinkedList {
    ListNode head;

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k, getLength(head));
    }

    public int getLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public ListNode reverse(ListNode head, int k, int length) {
        if (length < k || head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
            count++;
        }
        head.next = reverse(next, k, length - k);
        return prev;
    }


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
        // copy head in curr
        ListNode curr = head;
        // iterate over the list
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
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
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        // traversing the list
        while (curr != null) {

            // getting hold of next of curr
            ListNode next = curr.next;

            // making curr next as previous
            curr.next = prev;

            // new prev
            prev = curr;

            // new curr
            curr = next;
        }
        // since curr is null so prev is head now
        return prev;
    }


    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;

        ListNode list1 = new ListNode(-1);
        ListNode list2 = new ListNode(-1);

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = null;

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode leftNode = null;
        ListNode rightNode;
        ListNode list1Tail = null;
        ListNode list3Head = null;


        int count = 1;
        while (curr != null) {
            if (count == left - 1) {
                leftNode = curr.next;
                list1Tail = curr;
            } else if (count == right) {
                list3Head = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
            count++;
        }

        rightNode = leftNode;
        leftNode = reverse(leftNode);

        list1Tail.next = leftNode;
        rightNode.next = list3Head;

        if (left == 1) {
            return leftNode;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        int i = length - n;
        if (i == 0) {
            head = head.next;
            return head;
        }


        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (count == i) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            count++;
        }


        return head;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.append(40);
        linkedList.append(50);
        linkedList.head = linkedList.removeNthFromEnd(linkedList.head, 5);
        linkedList.traverse();
    }
}