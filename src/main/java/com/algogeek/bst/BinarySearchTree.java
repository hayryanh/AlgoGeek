package com.algogeek.bst;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public final class BinarySearchTree {
    private BinarySearchTree() {
    }

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

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    private static boolean dfs(Node<Integer> root, int min, int max) {
        // empty nodes are always valid
        if (root == null) return true;
        if (!(min < root.val && root.val < max)) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static boolean validBst(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
