package com.algomonster.pointers;

public final class LinkedListCycle {

    private LinkedListCycle() {
    }

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Detect if a linked list has a cycle using Floyd's Tortoise and Hare algorithm.
     *
     * @param nodes the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public static boolean hasCycle(Node<Integer> nodes) {
        if(nodes == null) return false;

        if(nodes.next == null) {
            return false;
        }

        Node<Integer> slow = nodes;
        Node<Integer> fast = nodes;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
