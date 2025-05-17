package com.algomonster.test.search;

import com.algomonster.pointers.PrefixSum;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrefixSumTest {

    @Test
    public void subarraySum() {
        // Test case 1: Normal case
        List<Integer> result1 = PrefixSum.subarraySum(List.of(1, 3, -3, 8, 5, 7), 5);
        assert result1.equals(List.of(2, 4)) : "Test case 1 failed";

        // Test case 2: all elements are the same
        List<Integer> result2 = PrefixSum.subarraySum(List.of(1, 1, 1), 3);
        assert result2.equals(List.of(0, 3)) : "Test case 2 failed";

        // Test case 3: k is zero
        List<Integer> result3 = PrefixSum.subarraySum(List.of(1, -20, -3, 30, 5, 7), 7);
        assert result3.equals(List.of(1, 4)) : "Test case 3 failed";
    }

    @Test
    public void subarraySumTotal() {
        // Test case 1: Normal case
        int result1 = PrefixSum.subarraySumTotal(List.of(10, 5, -5, -20, 10), -10);
        assert result1 == 3 : "Test case 1 failed";

        int result2 = PrefixSum.subarraySumTotal(List.of(1, 1, 1), 2);
        assert result2 == 2 : "Test case 2 failed";
    }

    @Test
    public void rangeSumQueryImmutable() {
        // Test case 1: Normal case
        int result1 = PrefixSum.rangeSumQueryImmutable(List.of(1, 2, 3, 4, 5), 1, 3);
        assert result1 == 9 : "Test case 1 failed";

        // Test case 2: Single element range
        int result2 = PrefixSum.rangeSumQueryImmutable(List.of(1, 2, 3, 4, 5), 2, 2);
        assert result2 == 3 : "Test case 2 failed";

        // Test case 3: Range covers the entire array
        int result3 = PrefixSum.rangeSumQueryImmutable(List.of(1, 2, 3, 4, 5), 0, 4);
        assert result3 == 15 : "Test case 3 failed";
    }

    @Test
    public void productOfArrayExceptSelf() {
        // Test case 1: Normal case
        List<Integer> result1 = PrefixSum.productOfArrayExceptSelf(List.of(1, 2, 3, 4));
        assert result1.equals(List.of(24, 12, 8, 6)) : "Test case 1 failed";

        // Test case 2: Single element
        List<Integer> result2 = PrefixSum.productOfArrayExceptSelf(List.of(5));
        assert result2.equals(List.of(1)) : "Test case 2 failed";

        // Test case 3: All elements are the same
        List<Integer> result3 = PrefixSum.productOfArrayExceptSelf(List.of(2, 2, 2));
        assert result3.equals(List.of(4, 4, 4)) : "Test case 3 failed";
    }
}
