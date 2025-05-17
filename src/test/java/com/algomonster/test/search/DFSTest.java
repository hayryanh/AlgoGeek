package com.algomonster.test.search;

import com.algomonster.dfs.DFS;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class DFSTest {

    @Test
    public void treeMaxDepth() {
        // Test case 1: Normal case
        int result1 = DFS.treeMaxDepth(buildTree(splitWords("5 4 3 x x 8 x x 6 x x").iterator(), Integer::parseInt));
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: All nodes have children
        int result2 = DFS.treeMaxDepth(buildTree(splitWords("6 x 9 x 11 x 7 x x").iterator(), Integer::parseInt));
        assert result2 == 3 : "Test case 2 failed";

        // Test case 3: Empty tree
        int result3 = DFS.treeMaxDepth(buildTree(splitWords("1 x x").iterator(), Integer::parseInt));
        assert result3 == 0 : "Test case 3 failed";
    }

    @Test
    public void visibleTreeNode() {
        // Test case 1: Normal case
        int result1 = DFS.visibleTreeNode(buildTree(splitWords("5 4 3 x x 8 x x 6 x x").iterator(), Integer::parseInt));
        assert result1 == 3 : "Test case 1 failed";

        // Test case 2: All negative values
        int result2 = DFS.visibleTreeNode(buildTree(splitWords("-100 x -500 x -50 x x").iterator(), Integer::parseInt));
        assert result2 == 2 : "Test case 2 failed";

        // Test case 3: Mixed values
        int result3 = DFS.visibleTreeNode(buildTree(splitWords("9 8 11 x x 20 x x 6 x x").iterator(), Integer::parseInt));
        assert result3 == 3 : "Test case 3 failed";
    }

    private static <T> DFS.Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        DFS.Node<T> left = buildTree(iter, f);
        DFS.Node<T> right = buildTree(iter, f);
        return new DFS.Node<T>(f.apply(val), left, right);
    }

    private static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    @Test
    public void isBalanced() {
        // Test case 1: Normal case
        boolean result1 = DFS.isBalanced(buildTree(splitWords("1 2 4 x 7 x x 5 x x 3 x 6 x x").iterator(), Integer::parseInt));
        assert result1 : "Test case 1 failed";

        // Test case 2: Unbalanced tree
        boolean result2 = DFS.isBalanced(buildTree(splitWords("1 2 4 x 7 x x 5 x x 3 x 6 8 x x x").iterator(), Integer::parseInt));
        assert !result2 : "Test case 2 failed";

        // Test case 3: Empty tree
        boolean result3 = DFS.isBalanced(buildTree(splitWords("1 2 3 x x 4 x 6 x x 5 x x").iterator(), Integer::parseInt));
        assert !result3 : "Test case 3 failed";
    }
}
