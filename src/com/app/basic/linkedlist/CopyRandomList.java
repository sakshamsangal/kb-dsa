package com.app.basic.linkedlist;

import java.util.HashMap;
import java.util.Objects;

public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node curr = head;
        Node temp = new Node(-1);
        Node head2 = temp;

        HashMap<Node, Node> map = new HashMap<>();
        while (Objects.nonNull(curr)) {

            temp.next = new Node(curr.val);
            map.put(curr, temp);

            curr = curr.next;
            temp = temp.next;
        }

        head2 = head2.next;
        curr = head;
        temp = head2;
        while (Objects.nonNull(curr)) {
            Node random = curr.random;
            temp.random = map.get(random);

            temp = temp.next;
            curr = curr.next;
        }

        return head2;
    }

    Node headRandom;

    void appendRandom(int k) {
        if (headRandom == null) { // if list is empty
            headRandom = new Node(k);
            return;
        }
        // if list is not empty
        // get hold of last node.
        Node temp = headRandom;
        while (temp.next != null) {
            temp = temp.next;
        }
        // insert the node
        temp.next = new Node(k);
    }


    public static void main(String[] args) {

        CopyRandomList l1 = new CopyRandomList();

        l1.appendRandom(10);
        l1.appendRandom(20);

        l1.copyRandomList(l1.headRandom);
    }
}