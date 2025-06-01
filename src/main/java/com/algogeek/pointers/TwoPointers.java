package com.algogeek.pointers;

import java.util.List;

/**
 * Two Pointers Pattern
 * This class contains various algorithms that use the two-pointer technique.
 */
public final class TwoPointers {

    private TwoPointers() {
    }

    /**
     * Remove duplicates from a sorted list.
     *
     * @param arr the sorted list of integers
     */
    public static int removeDuplicates(List<Integer> arr) {
        if(arr == null || arr.isEmpty()) {
            return 0;
        }

        if(arr.size() == 1) {
            return 1;
        }
        // Two pointers approach
        int slow = 0;
        for (int fast = 0; fast < arr.size(); fast++) {
            if (arr.get(fast) != arr.get(slow)) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        return slow + 1;
    }

    /**
     * Find the middle element of a linked list.
     *
     * @param head the head of the linked list
     */
    public static int middleOfLinkedList(Node<Integer> head) {
        if(head == null) {
            return -1; // or throw an exception
        }

        if(head.next == null) {
            return head.val;
        }
        // Two pointers approach
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * Move all zeros to the end of the list while maintaining the order of non-zero elements.
     *
     * @param nums the list of integers
     */
    public static void moveZeros(List<Integer> nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.size(); fast++) {
            if (nums.get(fast) != 0) {
                int tmp =  nums.get(slow);
                nums.set(slow, nums.get(fast));
                nums.set(fast, tmp);
                slow++;
            }
        }
    }

    /**
     * Find two numbers in a sorted array that sum up to a target value.
     *
     * @param arr the sorted array
     * @param target the target sum
     */
    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int twoSum = arr.get(left) + arr.get(right);
            if (twoSum == target) {
                return List.of(left, right);
            } else if (twoSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return List.of();
    }

    /**
     * Check if a string is a palindrome.
     *
     * @param s the input string
     */
    public static boolean isPalindrome(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        if(s == null || s.isEmpty()) {
            return false;
        }

        char[] arr = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase().toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            if(arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Find the maximum area of water that can be contained between two lines.
     *
     * @param arr the heights of the lines
     */
    public static int containerWithMostWater(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int maxArea = 0;
        while(left < right) {
            int area = Math.min(arr.get(left), arr.get(right)) * (right - left);
            if(maxArea < area) {
                maxArea = area;
            }
            if(arr.get(left) < arr.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Node class for a linked list.
     */
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
}
