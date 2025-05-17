package com.algomonster.test.search;

import com.algomonster.pointers.LinkedListCycle;
import org.junit.jupiter.api.Test;

public class LinkedListCycleTest {

    @Test
    public void hasCycle() {
        // Test case 1: Normal case
        LinkedListCycle.Node<Integer> head1 = new LinkedListCycle.Node<>(1);
        head1.next = new LinkedListCycle.Node<>(2);
        head1.next.next = new LinkedListCycle.Node<>(3);
        head1.next.next.next = head1; // Creating a cycle
        boolean result1 = LinkedListCycle.hasCycle(head1);
        assert result1 : "Test case 1 failed";

        // Test case 2: No cycle
        LinkedListCycle.Node<Integer> head2 = new LinkedListCycle.Node<>(1);
        head2.next = new LinkedListCycle.Node<>(2);
        head2.next.next = new LinkedListCycle.Node<>(3);
        boolean result2 = LinkedListCycle.hasCycle(head2);
        assert !result2 : "Test case 2 failed";

        // Test case 3: Single node with no cycle
        LinkedListCycle.Node<Integer> head3 = new LinkedListCycle.Node<>(1);
        boolean result3 = LinkedListCycle.hasCycle(head3);
        assert !result3 : "Test case 3 failed";
    }
}
