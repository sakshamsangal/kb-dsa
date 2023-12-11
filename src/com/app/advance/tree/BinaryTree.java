package com.app.advance.tree;

import com.app.util.Distance;
import com.app.util.TreeNode;

import java.util.*;

public class BinaryTree {
    static int res = 0;
    static Node prev1 = null;
    static Node head = null;
    TreeNode prev2 = null;
    static int prev = Integer.MIN_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        }

        if (Objects.nonNull(left)) {
            return left;
        }
        if (Objects.nonNull(right)) {
            return right;
        }

        return null;
    }


    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }


    public int isCSum(Node root) {
        if (Objects.isNull(root)) {
            return 1;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return 1;
        }

        int sum = 0;
        if (Objects.nonNull(root.left)) {
            sum += root.left.data;
        }
        if (Objects.nonNull(root.right)) {
            sum += root.left.data;
        }

        if (sum == root.data) {
            if (isCSum(root.left) == 1 && isCSum(root.right) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public void traverseDLL(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.println("temp.key = " + temp.data);
            temp = temp.right;
        }

    }


    public Node toDoublyLL(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }

        toDoublyLL(root.left);


        if (Objects.nonNull(prev1)) {
            prev1.right = root;
            root.left = prev1;
            prev1 = prev1.right;
        } else {
            head = root;
        }


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
        if (Objects.isNull(root)) {
            return true;
        }

        if (!isBST(root.left)) {
            return false;
        }

        if (prev < root.data) {
            prev = root.data;
            return isBST(root.right);
        }
        return false;

    }


    public boolean isBalanced(Node root) {

        return false;
    }

    public int height(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int count = 1;
        int left = height(root.left);
        int right = height(root.right);

        return count + Math.max(left, right);
    }


    public int kthSmallest(Node root, int k) {
        TreeTraversal treeTraversal = new TreeTraversal();
        List<Integer> ans = new ArrayList<>();
        treeTraversal.inOrder(ans, root);
        System.out.println("ans = " + ans);
        return ans.get(k);
    }

    public boolean findPath(Node root, List<Node> p, int n) {
        if (Objects.isNull(root)) {
            return false;
        }
        p.add(root);
        if (root.data == n) {
            return true;
        }
        boolean path1 = findPath(root.left, p, n);
        if (path1) {
            return true;
        }
        boolean path2 = findPath(root.right, p, n);
        if (path2) {
            return true;
        }
        p.remove(root);
        return false;
    }

    public Node lca(Node root, int n1, int n2) {
        List<Node> list1 = new ArrayList<>();
        boolean path1 = findPath(root, list1, n1);

        if (path1) {
            List<Node> list2 = new ArrayList<>();
            boolean path2 = findPath(root, list2, n2);
            if (path2) {
                int size = Math.min(list1.size(), list2.size());
                int i = 0;
                while (i < size) {
                    if (list1.get(i) != list2.get(i)) {
                        return list1.get(i - 1);
                    }
                    i++;
                }
                return list1.get(i - 1);
            }
        }
        return null;
    }


    public int sumNumbers(TreeNode root) {
        return sumNumbersRecur(root, 0);
    }

    public int sumNumbersRecur(TreeNode root, int num) {
        // leaf node
        int val = 10 * num + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }

        int i = 0, j = 0;

        // left has data
        if (root.left != null) {
            i = sumNumbersRecur(root.left, val);
        }


        // right has data
        if (root.right != null) {
            j = sumNumbersRecur(root.right, val);
        }

        return i + j;
    }


    public void flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        flatten(root.right);

        if (root.left == null) return;
        flatten(root.left);

        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = rightNode;
    }

    int currDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (Objects.isNull(root)) {
            return currDiff;
        }

        getMinimumDifference(root.left);

        if (Objects.nonNull(prev2)) {
            int diff = Math.abs(prev2.val - root.val);
            currDiff = Math.min(diff, currDiff);
        }
        prev2 = root;

        getMinimumDifference(root.right);

        return currDiff;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double sum = root.val;
        int levelSize;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            ans.add(sum / levelSize);
            sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    sum += poll.left.val;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    sum += poll.right.val;
                    queue.add(poll.right);
                }
            }
        }


        return ans;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return true;
        }

        // leaf
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return root.val == targetSum;
        }

        if (Objects.nonNull(root.left)) {
            boolean left = hasPathSum(root.left, targetSum - root.val);
            if (left) {
                return true;
            }
        }

        if (Objects.nonNull(root.right)) {
            return hasPathSum(root.right, targetSum - root.val);
        }

        return false;
    }






    public static void main(String[] args) {

//        TreeTraversal treeTraversal = new TreeTraversal();
//        BinaryTree binaryTree = new BinaryTree();
//        int[] arr = {3, 9, 20};
//        TreeNode root = treeTraversal.insertLevelOrder(arr, 0);
//        binaryTree.hasPathSum(root, 2);

    }


}
