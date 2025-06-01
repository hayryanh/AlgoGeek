package com.algogeek.test;

import com.algogeek.pointers.SlidingWindow;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SlidingWindowTest {

    @Test
    public void testSubarraySumFixed() {
        // Test case 1: Normal case
        int result1 = SlidingWindow.subarraySumFixed(List.of(1, 2, 3, 4, 5), 3);
        assert result1 == 12 : "Test case 1 failed";

        // Test case 2: k is larger than the array size
        int result2 = SlidingWindow.subarraySumFixed(List.of(1, 2, 3), 5);
        assert result2 == 0 : "Test case 2 failed";

        // Test case 3: k is zero
        int result3 = SlidingWindow.subarraySumFixed(List.of(1, 2, 3), 0);
        assert result3 == 0 : "Test case 3 failed";

        // Test case 4: Empty array
        int result4 = SlidingWindow.subarraySumFixed(List.of(), 2);
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single element array
        int result5 = SlidingWindow.subarraySumFixed(List.of(5), 1);
        assert result5 == 5 : "Test case 5 failed";
    }

    @Test
    public void findAllAnagrams() {
        // Test case 1: Normal case
        List<Integer> result1 = SlidingWindow.findAllAnagrams("cbaebabacd", "abc");
        assert result1.equals(List.of(0, 6)) : "Test case 1 failed";

        List<Integer> result11 = SlidingWindow.findAllAnagrams("abab", "ab");
        assert result11.equals(List.of(0, 1, 2)) : "Test case 1 failed";

        List<Integer> result111 = SlidingWindow.findAllAnagrams("nabanabannaabbaanana", "banana");
        assert result111.equals(List.of(0, 3, 5, 6, 7, 13)) : "Test case 1 failed";

        List<Integer> result1111 = SlidingWindow.findAllAnagrams("thequickbrownfoxjumpsoverthelazydog", "thelazydogjumpsoverthequickbrownfox");
        assert result1111.equals(List.of(0)) : "Test case 1 failed";

        // Test case 2: No anagrams
        List<Integer> result2 = SlidingWindow.findAllAnagrams("abcdefg", "xyz");
        assert result2.isEmpty() : "Test case 2 failed";

        // Test case 3: Empty original string
        List<Integer> result3 = SlidingWindow.findAllAnagrams("", "abc");
        assert result3.isEmpty() : "Test case 3 failed";

        // Test case 4: Empty check string
        List<Integer> result4 = SlidingWindow.findAllAnagrams("abcde", "");
        assert result4.isEmpty() : "Test case 4 failed";

        // Test case 5: Single character strings
        List<Integer> result5 = SlidingWindow.findAllAnagrams("a", "a");
        assert result5.equals(List.of(0)) : "Test case 5 failed";
    }

    @Test
    public void subarraySumLongest() {
        // Test case 1: Normal case
        int result1 = SlidingWindow.subarraySumLongest(List.of(1, 2, 3, 4, 5), 5);
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: k is larger than the array size
        int result2 = SlidingWindow.subarraySumLongest(List.of(1, 2, 3), 5);
        assert result2 == 2 : "Test case 2 failed";

        // Test case 3: k is zero
        int result3 = SlidingWindow.subarraySumLongest(List.of(1, 2, 3), 0);
        assert result3 == 0 : "Test case 3 failed";

        // Test case 4: Empty array
        int result4 = SlidingWindow.subarraySumLongest(List.of(), 2);
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single element array
        int result5 = SlidingWindow.subarraySumLongest(List.of(5), 5);
        assert result5 == 1 : "Test case 5 failed";
    }

    @Test
    public void longestSubstringWithoutRepeatingCharacters() {
        // Test case 1: Normal case
        int result1 = SlidingWindow.longestSubstringWithoutRepeatingCharacters("abcabcbb");
        assert result1 == 3 : "Test case 1 failed";

        // Test case 2: All unique characters
        int result2 = SlidingWindow.longestSubstringWithoutRepeatingCharacters("abcdefg");
        assert result2 == 7 : "Test case 2 failed";

        // Test case 3: All the same characters
        int result3 = SlidingWindow.longestSubstringWithoutRepeatingCharacters("aaaaaa");
        assert result3 == 1 : "Test case 3 failed";

        // Test case 4: Empty string
        int result4 = SlidingWindow.longestSubstringWithoutRepeatingCharacters("");
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single character string
        int result5 = SlidingWindow.longestSubstringWithoutRepeatingCharacters("a");
        assert result5 == 1 : "Test case 5 failed";
    }

    @Test
    public void subarraySumShortest() {
        // Test case 1: Normal case
        int result1 = SlidingWindow.subarraySumShortest(List.of(2, 3, 1, 2, 4, 3), 7);
        assert result1 == 2 : "Test case 1 failed";

        // Test case 2: No valid subarray
        int result2 = SlidingWindow.subarraySumShortest(List.of(1, 2, 3), 7);
        assert result2 == 0 : "Test case 2 failed";

        // Test case 3: k is zero
        int result3 = SlidingWindow.subarraySumShortest(List.of(1, 2, 3), 0);
        assert result3 == 0 : "Test case 3 failed";

        // Test case 4: Empty array
        int result4 = SlidingWindow.subarraySumShortest(List.of(), 2);
        assert result4 == 0 : "Test case 4 failed";

        // Test case 5: Single element array
        int result5 = SlidingWindow.subarraySumShortest(List.of(5), 5);
        assert result5 == 1 : "Test case 5 failed";
    }

    @Test
    public void leastConsecutiveCardsToMatch() {
        // Test case 1: Normal case
        int result1 = SlidingWindow.leastConsecutiveCardsToMatch(List.of(3, 4, 2, 3, 4, 7));
        assert result1 == 4 : "Test case 1 failed";

        // Test case 2: No valid subarray
        int result2 = SlidingWindow.leastConsecutiveCardsToMatch(List.of(1, 0, 5, 3));
        assert result2 == -1 : "Test case 2 failed";

        // Test case 3: Single element array
        int result3 = SlidingWindow.leastConsecutiveCardsToMatch(List.of(5));
        assert result3 == -1 : "Test case 3 failed";

        // Test case 4: All elements are the same
        int result4 = SlidingWindow.leastConsecutiveCardsToMatch(List.of(7, 7));
        assert result4 == 2 : "Test case 4 failed";

        // Test case 5: Empty array
        int result5 = SlidingWindow.leastConsecutiveCardsToMatch(List.of());
        assert result5 == -1 : "Test case 5 failed";
    }

    @Test
    public void getMinimumWindow() {
        // Test case 1: Normal case
        String result1 = SlidingWindow.getMinimumWindow("ADOBECODEBANC", "ABC");
        assert result1.equals("BANC") : "Test case 1 failed";

        // Test case 2: No valid window
        String result2 = SlidingWindow.getMinimumWindow("a", "aa");
        assert result2.isEmpty() : "Test case 2 failed";

        // Test case 3: Empty string
        String result3 = SlidingWindow.getMinimumWindow("", "abc");
        assert result3.isEmpty() : "Test case 3 failed";

        // Test case 4: Single character strings
        String result4 = SlidingWindow.getMinimumWindow("a", "a");
        assert result4.equals("a") : "Test case 4 failed";

        // Test case 5: All characters are the same
        String result5 = SlidingWindow.getMinimumWindow("aaaaaa", "aa");
        assert result5.equals("aa") : "Test case 5 failed";
    }

    @Test
    public void maximumScore() {
        // Test case 1:
        int result1 = SlidingWindow.maximumScore(List.of(2, 4, 5, 8, 10), List.of(4, 6, 8, 9));
        assert result1 == 30 : "Test case 1 failed";

        // Test case 2:
        int result2 = SlidingWindow.maximumScore(List.of(1, 4, 5, 8, 9), List.of(2, 3, 6, 7, 10));
        assert result2 == 28 : "Test case 2 failed";

        // Test case 3:
        int result3 = SlidingWindow.maximumScore(List.of(2, 3, 5, 6, 7, 9, 11, 13, 14, 16, 17, 19, 20),
                List.of(3, 4, 5, 7, 8, 10, 11, 12, 15, 16, 18, 20));
        assert result3 == 155 : "Test case 3 failed";
    }
}
