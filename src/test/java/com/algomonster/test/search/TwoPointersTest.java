package com.algomonster.test.search;

import com.algomonster.pointers.TwoPointers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TwoPointersTest {

    @Test
    public void testRemoveDuplicates() {
        // Test case 1: Normal case
        int result1 = TwoPointers.removeDuplicates(new ArrayList<>(List.of(1, 2, 2, 3, 4)));
        assert result1 == 4 : "Test case 1 failed";

        // Test case 2: All duplicates
        int result2 = TwoPointers.removeDuplicates(new ArrayList<>(List.of(1, 1, 1, 1)));
        assert result2 == 1 : "Test case 2 failed";

        // Test case 3: No duplicates
        int result3 = TwoPointers.removeDuplicates(new ArrayList<>(List.of(1, 2, 3, 4)));
        assert result3 == 4 : "Test case 3 failed";

        // Test case 4: Empty array
        int result4 = TwoPointers.removeDuplicates(new ArrayList<>(List.of()));
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single element array
        int result5 = TwoPointers.removeDuplicates(new ArrayList<>(List.of(5)));
        assert result5 == 1 : "Test case 5 failed";
    }

    @Test
    public void testMiddleOfLinkedList() {
        // Test case 1: Normal case
        TwoPointers.Node<Integer> head1 = new TwoPointers.Node<>(1, new TwoPointers.Node<>(2, new TwoPointers.Node<>(3)));
        int result1 = TwoPointers.middleOfLinkedList(head1);
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: Single element
        TwoPointers.Node<Integer> head2 = new TwoPointers.Node<>(1);
        int result2 = TwoPointers.middleOfLinkedList(head2);
        assert result2 == 1 : "Test case 2 failed";

        // Test case 3: Empty list
        TwoPointers.Node<Integer> head3 = null;
        int result3 = TwoPointers.middleOfLinkedList(head3);
        assert result3 == -1 : "Test case 3 failed";
    }

    @Test
    public void moveZeros() {
        // Test case 1: Normal case
        List<Integer> nums1 = new ArrayList<>(List.of(0, 1, 0, 3, 12));
        TwoPointers.moveZeros(nums1);
        assert nums1.equals(List.of(1, 3, 12, 0, 0)) : "Test case 1 failed";

        // Test case 2: All zeros
        List<Integer> nums2 = new ArrayList<>(List.of(0, 0, 0));
        TwoPointers.moveZeros(nums2);
        assert nums2.equals(List.of(0, 0, 0)) : "Test case 2 failed";

        // Test case 3: No zeros
        List<Integer> nums3 = new ArrayList<>(List.of(1, 2, 3));
        TwoPointers.moveZeros(nums3);
        assert nums3.equals(List.of(1, 2, 3)) : "Test case 3 failed";

        // Test case 4: Empty array
        List<Integer> nums4 = new ArrayList<>();
        TwoPointers.moveZeros(nums4);
        assert nums4.equals(List.of()) : "Test case 4 failed";
    }

    @Test
    public void twoSumSorted() {
        char[] arr = "Do geese see God".toLowerCase().replace(" ", "").toCharArray();

        // Test case 1: Normal case
        List<Integer> arr1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int target1 = 6;
        List<Integer> result1 = TwoPointers.twoSumSorted(arr1, target1);
        assert result1.equals(List.of(0, 4)) : "Test case 1 failed";

        List<Integer> arr2 = new ArrayList<>(List.of(100, 1000, 2001, 3000, 4000, 5000));
        int target2 = 5001;
        List<Integer> result2= TwoPointers.twoSumSorted(arr2, target2);
        assert result2.equals(List.of(2, 3)) : "Test case 1 failed";

        // Test case 2: No solution
        List<Integer> arr3 = new ArrayList<>(List.of(1, 2, 3));
        int target3 = 7;
        List<Integer> result3 = TwoPointers.twoSumSorted(arr3, target3);
        assert result3.equals(List.of()) : "Test case 2 failed";

        // Test case 3: Empty array
        List<Integer> arr4 = new ArrayList<>();
        int target4 = 5;
        List<Integer> result4 = TwoPointers.twoSumSorted(arr4, target4);
        assert result4.equals(List.of()) : "Test case 3 failed";
    }

    @Test
    public void isPalindrome() {
        assert TwoPointers.isPalindrome("Do geese see God") : "Test case 1 failed";

        assert !TwoPointers.isPalindrome("Hello") : "Test case 2 failed";

        assert !TwoPointers.isPalindrome("") : "Test case 3 failed";
    }

    @Test
    public void containerWithMostWater() {
        // Test case 1: Normal case
        List<Integer> heights1 = new ArrayList<>(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7));
        int result1 = TwoPointers.containerWithMostWater(heights1);
        assert result1 == 49 : "Test case 1 failed";

        // Test case 2: All the same height
        List<Integer> heights2 = new ArrayList<>(List.of(5, 5, 5, 5));
        int result2 = TwoPointers.containerWithMostWater(heights2);
        assert result2 == 15 : "Test case 2 failed";

        // Test case 3: Decreasing heights
        List<Integer> heights3 = new ArrayList<>(List.of(5, 4, 3, 2, 1));
        int result3 = TwoPointers.containerWithMostWater(heights3);
        assert result3 == 6 : "Test case 3 failed";

        // Test case 4: Empty array
        List<Integer> heights4 = new ArrayList<>();
        int result4 = TwoPointers.containerWithMostWater(heights4);
        assert result4 == 0 : "Test case 4 failed";
    }
}
