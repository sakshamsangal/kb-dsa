package array;

public class MergeTwoSortedLinkedLists {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

        LinkedListNode<Integer> head = new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp = head;
        while (first != null && second != null) {
            if (first.data < second.data) {

                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        while (first != null) {
            temp.next = first;
            first = first.next;
        }

        while (second != null) {
            temp.next = second;
            second = second.next;
        }
        return head.next;
    }
}