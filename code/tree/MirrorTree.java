package tree;

public class MirrorTree {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.left.left = new Node(70);
        int leaf = 50;
//        int i = mirror(root).data;

    }


    public static Node dll(Node root, Node prev) {

        if (root == null){
            return null;
        }

        Node head = dll(root.left,prev);
        if (prev == null){
            head = prev;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;



        dll(root.right,prev);
        return head;
    }




    static class Node {
        int data;
        Node left;
        Node right;

        Node(int k) {
            data = k;
            left = right = null;
        }
    }
}