package tree;

public class ToDLL {
    public static void traverseDLL(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.println("temp.key = " + temp.key);
            temp = temp.right;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(9);

        Node head = toDLL(root);
        traverseDLL(head);
//        System.out.print(toDLL(root));
    }

    static Node prev = null;

    public static Node toDLL(Node root) {
        if (root == null)
            return null;

        Node head = toDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        System.out.println("root = " + root.key);
        toDLL(root.right);
        return head;
    }

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }
}