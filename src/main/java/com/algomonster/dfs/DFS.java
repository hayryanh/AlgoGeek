package com.algomonster.dfs;

public final class DFS {
    private DFS() {
    }

    /**
     * Node class for a binary tree.
     */
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //================= Tree Max Depth =================
    private static int dfs(Node<Integer> root) {
        // Null node adds no depth
        if (root == null) return 0;
        // num nodes in the longest path of the current subtree = max num nodes of its two subtrees + 1 current node
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    /**
     * Calculate the maximum depth of a binary tree.
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the binary tree
     */
    public static int treeMaxDepth(Node<Integer> root) {
        return (root != null) ? dfs(root) - 1 : 0;
    }

    //================= Visible Tree Nodes =================
    private static int dfs(Node<Integer> root, int maxSoFar) {
        if (root == null) return 0;
        int total = 0;
        if (root.val >= maxSoFar) {
            total++;
        }
        // maxSoFar of the child node is the larger value of previous max and current node val
        total += dfs(root.left, Math.max(maxSoFar, root.val));
        total += dfs(root.right, Math.max(maxSoFar, root.val));

        return total;
    }

    public static int visibleTreeNode(Node<Integer> root) {
        // Start maxSoFar with the smallest integer value possible, so any value root has is greater than it
        return dfs(root, Integer.MIN_VALUE);
    }

    //================= Balanced Binary Tree =================
    // Returns -1 if is not a balanced binary tree. The height if it is.
    private static int treeHeight(Node<Integer> tree) {
        if (tree == null) {
            return 0;
        }
        int leftHeight = treeHeight(tree.left);
        int rightHeight = treeHeight(tree.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(Node<Integer> tree) {
        return treeHeight(tree) != -1;
    }
}
