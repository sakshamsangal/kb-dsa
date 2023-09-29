package com.app.advance.tree;

import com.app.util.Distance;
import com.app.util.Node;
import com.app.util.TreeNode;

import java.util.*;

public class BinaryTree {
    static int res = 0;
    static Node prev1 = null;
    static int prev = Integer.MIN_VALUE;

    public boolean isCSum(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        return (root.data == sum && isCSum(root.left) && isCSum(root.right));
    }


    // empty tree height = 0
    // max number of nodes from root to leaf
    void toDLL(Node prev, Node curr) {
        if (curr != null) {
            toDLL(prev, curr.left);
            if (prev != null) {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            toDLL(prev, curr.right);
        }
    }


    public void traverseDLL(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.println("temp.key = " + temp.data);
            temp = temp.right;
        }

    }


    public Node toDoublyLL(Node root) {
        if (root == null)
            return null;

        Node head = toDoublyLL(root.left);

        if (prev1 == null) {
            head = root;
        } else {
            root.left = prev1;
            prev1.right = root;
        }
        prev1 = root;
        System.out.println("root = " + root.data);
        toDoublyLL(root.right);
        return head;
    }


    public int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return (1 + leftHeight(root.left));
        }
    }


    public int rightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return (1 + rightHeight(root.right));
        }
    }

    public int countNodes(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int i = leftHeight(root);
        int j = rightHeight(root);
        // pbt
        if (i == j) {
            return (int) (Math.pow(2, i) - 1);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int burnTime(Node root, int leaf, Distance dist) {
        if (root == null) return 0;
        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1), rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rh);
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lh);
        }
        return Math.max(lh, rh) + 1;
    }

    public int diameter(Node root) {
        if (root == null)
            return 0;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        res = Math.max(res, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }

    static boolean isBST(Node root) {
        if (root == null)
            return true;
        if (!isBST(root.left)) return false;
        if (root.data < prev) return false;
        prev = root.data;
        return isBST(root.right);
    }

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (1 + Math.max(height(root.left), height(root.right)));
        }
    }

    // Function to insert nodes in level order
    public Node insertLevelOrder(int[] arr, int i) {
        Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public int kthSmallest(Node root, int k) {
        TreeTraversal treeTraversal = new TreeTraversal();
        List<Integer> ans = new ArrayList<>();
        treeTraversal.inOrder(ans, root);
        System.out.println("ans = " + ans);
        return ans.get(k);
    }

    public boolean findPath(Node root, ArrayList<Node> p, int n) {
        if (root == null) return false;

        // first take action
        // then check if action taken was correct or not
        p.add(root);
        if (root.data == n) return true;

        if (findPath(root.left, p, n) || findPath(root.right, p, n)) return true;

        p.remove(p.size() - 1);

        return false;
    }

    public Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if (!findPath(root, path1, n1) || !findPath(root, path2, n2))
            return null;
        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++)
            if (path1.get(i + 1) != path2.get(i + 1))
                return path1.get(i);
        return null;
    }

    public Node lca2(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node lca1 = lca2(root.left, n1, n2);
        Node lca2 = lca2(root.right, n1, n2);

        if (lca1 != null && lca2 != null)
            return root;
        if (lca1 != null)
            return lca1;
        else
            return lca2;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        int[] arr = {1, 2, 3, 4, 5, 6, 7,10,9,8};
        Node root = binaryTree.insertLevelOrder(arr, 0);
        binaryTree.kthSmallest(root,3);
    }
    //    public static void main(String[] args) {
    //        Node root = new Node(10);
    //        root.left = new Node(20);
    //        root.right = new Node(30);
    //        root.right.left = new Node(40);
    //        root.right.right = new Node(50);
    //        int n1 = 20, n2 = 50;
    //
    //        Node ans = lca(root, n1, n2);
    //        System.out.println("LCA: " + ans.data);
    //    }

}
