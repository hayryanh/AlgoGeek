package com.algomonster.test.search;

import com.algomonster.search.BinarySearch;
import org.junit.jupiter.api.Test;

import java.util.List;


public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        // Test case 1: Normal case
        int target1 = 3;
        int result1 = BinarySearch.binarySearch(List.of(1, 2, 3, 4, 5), target1);
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: Target not found
        int target2 = 6;
        int result2 = BinarySearch.binarySearch(List.of(1, 2, 3, 4, 5), target2);
        assert result2 == -1 : "Test case 2 failed";

        // Test case 3: Empty array
        int target3 = 1;
        int result3 = BinarySearch.binarySearch(List.of(), target3);
        assert result3 == -1 : "Test case 3 failed";

        // Test case 4: Single element array (target found)
        int target4 = 5;
        int result4 = BinarySearch.binarySearch(List.of(5), target4);
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single element array (target not found)
        int target5 = 10;
        int result5 = BinarySearch.binarySearch(List.of(5), target5);
        assert result5 == -1 : "Test case 5 failed";
    }

    @Test
    public void testBoundarySearch() {
        // Test case 1: Normal case
        int result1 = BinarySearch.boundarySearch(List.of(false, false, true, true, true));
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: All false
        int result2 = BinarySearch.boundarySearch(List.of(false, false, false));
        assert result2 == -1 : "Test case 2 failed";

        // Test case 3: All true
        int result3 = BinarySearch.boundarySearch(List.of(true, true, true));
        assert result3 == 0 : "Test case 3 failed";

        // Test case 4: Empty array
        int result4 = BinarySearch.boundarySearch(List.of());
        assert result4 == -1 : "Test case 4 failed";

        // Test case 5: Single element array (true)
        int result5 = BinarySearch.boundarySearch(List.of(true));
        assert result5 == 0 : "Test case 5 failed";

        // Test case 6: Single element array (false)
        int result6 = BinarySearch.boundarySearch(List.of(false));
        assert result6 == -1 : "Test case 6 failed";
    }
}
