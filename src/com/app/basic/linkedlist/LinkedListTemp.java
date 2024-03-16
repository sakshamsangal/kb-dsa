/*
package com.app.basic.linkedlist;

import com.app.util.ListNode;
import com.app.util.NodeRandom;

import java.util.HashMap;
import java.util.Objects;

public class LinkedListTemp {
    ListNode head;
    Node head2;
    NodeRandom headRandom;

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k, getLength(head));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode curr = head;
        ListNode temp = null;
        ListNode leftNode = null;
        ListNode leftNodePrev = null;
        ListNode prev = null;
        int count = 1;

        while (curr != null) {
            ListNode next = curr.next;
            if (count == left) {
                leftNodePrev = prev;
                leftNode = curr;
                temp = curr;
                temp.next = null;
            } else if (left < count && count < right) {
                curr.next = temp;
                temp = curr;
            } else if (count == right) {
                curr.next = temp;
                temp = curr;
                if (leftNodePrev != null) {
                    leftNodePrev.next = temp;
                }
                leftNode.next = next;
                break;
            }
            prev = curr;
            curr = next;
            count++;
        }
        if (left == 1) {
            return curr;
        }
        return head;
    }


    public ListNode getTail(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        int count = 0;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        return prev;
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

    void appendRandom(int k) {
        if (headRandom == null) { // if list is empty
            headRandom = new NodeRandom(k);
            return;
        }
        // if list is not empty
        // get hold of last node.
        NodeRandom temp = headRandom;
        while (temp.next != null) {
            temp = temp.next;
        }
        // insert the node
        temp.next = new NodeRandom(k);
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
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    void traverseRandom() {
        NodeRandom curr = headRandom;

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


    //Function to check if the linked list has a loop.
//    public static boolean detectLoop(Node head) {
//
//        if (head == null) {
//            return false;
//        }
//
//        Node slow = head;
//        Node fast = head.next;
//
//        while (fast.next != null) {
//            if (slow == fast) {
//                return true;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return false;
//    }

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


    public ListNode rotateRight(ListNode head, int k) {
        */
/*
         * need 2 tail
         * 5 next head
         * 3 next null
         * *//*


        ListNode curr = head;
        ListNode newHead = null;

        int len = getLength(head) - 1;
        for (int i = 0; i < len; i++) {
            if (i == len - k) {
                newHead = curr;
            }
            curr = curr.next;
        }
        curr.next = head;
        head = newHead.next;
        newHead.next = null;


        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h3 = new ListNode(-1);
        ListNode t3 = h3;
        ListNode curr = l1;
        ListNode curr2 = l2;
        while (curr != null & curr2 != null) {
            t3.next = new ListNode(curr.val + curr2.val);
            t3 = t3.next;
            curr = curr.next;
            curr2 = curr2.next;
        }
        while (curr != null) {
            t3.next = new ListNode(curr.val);
            t3 = t3.next;
            curr = curr.next;
        }
        while (curr2 != null) {
            t3.next = new ListNode(curr2.val);
            t3 = t3.next;
            curr2 = curr2.next;
        }
        h3 = h3.next;

        curr = h3;
        while (curr != null) {
            if (9 < curr.val) {
                curr.val = curr.val % 10;
                if (curr.next == null) {
                    curr.next = new ListNode(1);
                } else {
                    curr.next.val += 1;
                }
            }
            curr = curr.next;
        }
        return h3;
    }


    public NodeRandom copyRandomList(NodeRandom head) {
        HashMap<String, NodeRandom> map = new HashMap<>();
        NodeRandom curr = head;
        NodeRandom h1 = new NodeRandom(-1);
        NodeRandom t1 = h1;
        int c = 0;
        while (curr != null) {
            t1.next = new NodeRandom(curr.val);
            t1 = t1.next;
            map.put(c + "_" + t1.val, t1);
            curr = curr.next;
            c++;
        }
        h1 = h1.next;

        curr = head;
        NodeRandom temp = h1;
        c = 0;
        while (curr != null) {
            if (curr.random != null) {
                temp.random = map.get(c + "_" + curr.random.val);
            }
            curr = curr.next;
            temp = temp.next;
            c++;
        }

        return h1;
    }

    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);

        return mergeTwoLists(h1, h2);
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode fh = new ListNode(-1);
        ListNode ft = fh;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ft.next = head1;
                head1 = head1.next;
            } else {
                ft.next = head2;
                head2 = head2.next;
            }
            ft = ft.next;
        }

        while (head1 != null) {
            ft.next = head1;
            head1 = head1.next;
            ft = ft.next;

        }

        while (head2 != null) {
            ft.next = head2;
            head2 = head2.next;
            ft = ft.next;
        }

        return fh.next;

    }

    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    private ListNode reverseRec(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseRec(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;

        return newHead;

    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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

    public int pairSum(ListNode head) {
        if (Objects.isNull(head)) {
            return 0;
        }
        int len = getLength(head);
        int mid = len / 2;
        ListNode startNode = head;
        ListNode midNode = head;

        for (int i = 0; i < mid; i++) {
            midNode = midNode.next;
        }

        ListNode midNodeRev = reverse(midNode);

        int currMax = 0;
        for (int i = 0; i < mid; i++) {
            currMax = Math.max(currMax, startNode.val + midNodeRev.val);
            startNode = startNode.next;
            midNodeRev = midNodeRev.next;
        }

        return currMax;
    }

    public Node insertionSort(Node head_ref) {
        if (Objects.isNull(head_ref) || Objects.isNull(head_ref.next)) {
            return head_ref;
        }
        Node newHead = head_ref;
        head_ref = head_ref.next;

        while (head_ref != null) {
            Node curr = newHead;
            Node next = head_ref.next;
            // 10 20 30 40 .. 25

            if (head_ref.data < curr.data) {
                head_ref.next = curr;
                newHead = head_ref;
            } else {
                while (curr.next != null && curr.next.data > head_ref.data) {
                    curr = curr.next;
                }
                Node newNext = curr.next;
                curr.next = head_ref;
                head_ref.next = newNext;
            }
            head_ref = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListTemp l1 = new LinkedListTemp();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);

        int i = l1.insertionSort();
        System.out.println("i = " + i);


    }
}*/
