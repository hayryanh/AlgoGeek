package com.algogeek.test;

import com.algogeek.bst.BinarySearchTree;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void validBst() {
        // Test case 1: Normal case
        assert BinarySearchTree.validBst(BinarySearchTree.buildTree(
                BinarySearchTree.splitWords("6 4 3 x x 5 x x 8 x x").iterator(), Integer::parseInt));

        // Test case 2: All nodes have children
        assert BinarySearchTree.validBst(BinarySearchTree.buildTree(
                BinarySearchTree.splitWords("3 2 1 x x x 4 x 5 x x").iterator(), Integer::parseInt));

        // Test case 3: Empty tree
        assert !BinarySearchTree.validBst(BinarySearchTree.buildTree(
                BinarySearchTree.splitWords("6 4 3 x x 8 x x 8 x x").iterator(), Integer::parseInt));
    }
}
