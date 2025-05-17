package com.algomonster.pointers;

import java.util.*;

public final class SlidingWindow {

    public static final int MODULO_AMT = 1000000007;

    private SlidingWindow() {
    }

    /**
     * Find the maximum sum of a subarray of fixed size k.
     *
     * @param nums the list of integers
     * @param k    the size of the subarray
     * @return the maximum sum of the subarray
     */
    public static int subarraySumFixed(List<Integer> nums, int k) {
        int left = 0;
        int right = k;
        int sum = 0;
        while (right <= nums.size()) {
            int subSum = 0;
            for (int i = left; i < (left + k); i++) {
                subSum += nums.get(i);
            }

            if (sum < subSum) {
                sum = subSum;
            }

            left++;
            right++;
        }

        return sum;
    }

    /**
     * Find all anagrams of a string in another string.
     *
     * @param original the original string
     * @param check    the string to check for anagrams
     * @return a list of starting indices of anagrams of the check string in the original string
     */
    public static List<Integer> findAllAnagrams(String original, String check) {
        if (check == null || check.isEmpty()) return List.of();

        if (original == null || original.isEmpty()) return List.of();

        int originalLen = original.length();
        int checkLen = check.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (originalLen < checkLen) return res;

        // stores the frequency of each character in the check string
        int[] checkCounter = new int[26];
        // stores the frequency of each character in the current window
        int[] window = new int[26];
        // first window
        for (int i = 0; i < checkLen; i++) {
            checkCounter[check.charAt(i) - 'a']++;
            window[original.charAt(i) - 'a']++;
        }
        if (Arrays.equals(window, checkCounter)) res.add(0);

        for (int i = checkLen; i < originalLen; i++) {
            window[original.charAt(i - checkLen) - 'a']--;
            window[original.charAt(i) - 'a']++;
            if (Arrays.equals(window, checkCounter)) res.add(i - checkLen + 1);
        }
        return res;
    }

    /**
     * Find the longest subarray with a sum less than or equal to a target.
     *
     * @param nums   the list of integers
     * @param target the target sum
     * @return the length of the longest subarray
     */
    public static int subarraySumLongest(List<Integer> nums, int target) {
        int windowSum = 0;
        int length = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); ++right) {
            windowSum += nums.get(right);
            while (windowSum > target) {
                windowSum -= nums.get(left);
                ++left;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    /**
     * Find the length of the longest substring without repeating characters.
     *
     * @param s the input string
     * @return int - the length of the longest substring without repeating characters
     */
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (lastIndex[currentChar] >= start) {
                start = lastIndex[currentChar] + 1;
            }

            maxLen = Math.max(maxLen, i - start + 1);

            lastIndex[currentChar] = i;
        }

        return maxLen;
    }

    /**
     * Find the length of the shortest subarray with a sum greater than or equal to a target.
     *
     * @param nums   the list of integers
     * @param target the target sum
     * @return the length of the shortest subarray
     */
    public static int subarraySumShortest(List<Integer> nums, int target) {
        if (target == 0) {
            return 0;
        }

        int windowSum = 0;
        int length = nums.size() + 1;
        int left = 0;
        for (int right = 0; right < nums.size(); ++right) {
            windowSum += nums.get(right);
            while (windowSum >= target) {
                length = Math.min(length, right - left + 1);
                windowSum -= nums.get(left);
                ++left;
            }
        }
        if (length > nums.size()) {
            return 0;
        }

        return length;
    }

    /**
     * Find the least number of consecutive cards to match.
     *
     * @param cards the list of integers representing the cards
     * @return int - the length of the shortest subarray with at least one duplicate
     */
    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int shortest = cards.size() + 1;
        for (int right = 0; right < cards.size(); ++right) {
            window.put(cards.get(right), window.getOrDefault(cards.get(right), 0) + 1);
            while (window.get(cards.get(right)) == 2) {
                shortest = Math.min(shortest, right - left + 1);
                window.put(cards.get(left), window.get(cards.get(left)) - 1);
                ++left;
            }
        }
        return shortest != cards.size() + 1 ? shortest : -1;
    }

    /**
     * Given two strings, original and check, return the minimum substring of original such that each character in check, including duplicates, are included in this substring. By "minimum", I mean the shortest substring. If two substrings that satisfy the condition have the same length, the one that comes lexicographically first is smaller.
     * <p>
     * Parameters
     * original: The original string.
     * Check: The string to check if a window contains it.
     * Result
     * The smallest substring of the original that satisfies the condition.
     * Examples
     * Example 1
     * Input: original = "cdbaebaecd", check = "abc"
     * </p>
     * <p>
     * Output: baec
     * </p>
     * <p>
     * Explanation: baec is the shortest substring of the original that contains all of a, b, and c.
     * </p>
     *
     * @param original the original string
     * @param check    the string to check for
     * @return the minimum window substring
     */
    public static String getMinimumWindow(String original, String check) {
        HashMap<Character, Integer> checkCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();
        for (char ch : check.toCharArray()) {
            checkCount.merge(ch, 1, Integer::sum);
        }
        int satisfied = 0;
        int required = checkCount.size();
        int m = original.length();
        int window = -1;
        int length = m + 1;
        int l = 0;
        for (int r = 0; r < m; ++r) {
            windowCount.put(original.charAt(r), windowCount.getOrDefault(original.charAt(r), 0) + 1);
            if (Objects.equals(windowCount.get(original.charAt(r)), checkCount.get(original.charAt(r)))) {
                satisfied++;
            }
            while (satisfied == required) {
                if (r - l + 1 < length ||
                        (r - l + 1 == length && original.substring(l, r + 1).compareTo(original.substring(window, window + length)) < 0)) {
                    window = l;
                    length = r - l + 1;
                }
                windowCount.put(original.charAt(l), windowCount.get(original.charAt(l)) - 1);
                if (checkCount.containsKey(original.charAt(l)) && windowCount.get(original.charAt(l)) < checkCount.get(original.charAt(l))) {
                    satisfied--;
                }
                l++;
            }
        }
        return window >= 0 ? original.substring(window, window + length) : "";
    }

    /**
     * <p>
     * You are given two sorted arrays of distinct integers, arr1, and arr2.
     * Your goal is to start from the beginning of one array and arrive at the end of one array (it could be the same array or not).
     * </p>
     * <p>
     * For each step, you can either move forward a step on an array or move to a square in the other array where the
     * number is the same as the number in your current square ("teleportation").
     * Your total score is defined as the sum of all unique numbers that you have been on.
     * </p>
     * <p>
     * Find the maximum score that you can get given the above rules.
     * Since the result might be very large and cause overflow, return the maximum score modded by 10^9 + 7.
     * </p>
     *
     * <p>
     * Find the maximum score that you can get given the above rules.
     * Since the result might be very large and cause overflow, return the maximum score modded by 10^9 + 7.
     * </p>
     *
     * <p>
     * <li>Solution</li>
     * <ul>
     *     For simplicity, we call numbers that appears multiple times "teleporters".
     *     Because both arrays are ordered and distinct, the teleporter number must appear in both arrays exactly once,
     *     and each teleporter in both arrays must be ordered in the same manner.
     * </ul>
     * <ul>
     *     Consider the interval between two teleporters.
     *     If there are no numbers between these two numbers that appear in both arrays, then in those steps you can only go forward.
     *     Therefore, the score in that section would be the sum of the subarray in that section.
     * </ul>
     * <ul>
     *     Furthermore, regardless of where you start, it does not affect the choice whether to go top or go bottom in that section.
     *     If you start from the top array, you can go left to continue the top array, and teleport to the bottom array.
     *     The same goes for if you start from the bottom array.
     *     In that case, to maximize the score, we only need to maximize the score of each interval between two teleporters.
     * </ul>
     * <ul>
     *     Note that the same holds true for numbers before the first teleporter and after the final teleporter, so we can apply the same logic.
     * </ul>
     * <p/>
     */
    public static int maximumScore(List<Integer> arr1, List<Integer> arr2) {
        // WRITE YOUR BRILLIANT CODE HERE
        int ptr1 = 0, ptr2 = 0;
        int n1 = arr1.size(), n2 = arr2.size();
        // We use long for these attributes because they can exceed the integer limit.
        // The max score, summed up and modded
        long result = 0;
        // The sum of the subarray between the previous teleporter and the pointer for each array
        long sectionSum1 = 0, sectionSum2 = 0;
        // As long as the two arrays are not both at the end, we advance the pointers
        while (ptr1 < n1 || ptr2 < n2) {
            // If they match, we sum up the max score of that section and the score of
            // the current position, then shrink the result by using modulo
            // Reset the sums and move the pointers afterward
            if (ptr1 < n1 && ptr2 < n2 && arr1.get(ptr1).equals(arr2.get(ptr2))) {
                result += Math.max(sectionSum1, sectionSum2) + arr1.get(ptr1);
                result %= MODULO_AMT;
                sectionSum1 = 0;
                sectionSum2 = 0;
                ptr1++;
                ptr2++;
                continue;
            }
            // If either "ptr1" reaches the end, or "ptr2" is smaller than "ptr1"
            // we move "ptr2" and keep track of the sum.
            if (ptr1 == n1 || (ptr2 != n2 && arr1.get(ptr1) > arr2.get(ptr2))) {
                sectionSum2 += arr2.get(ptr2);
                ptr2++;
            } else {
                // Otherwise, we move "ptr1" and keep track of that sum
                sectionSum1 += arr1.get(ptr1);
                ptr1++;
            }
        }
        // Add the remaining max section sum to the result, then return the result
        // modulo
        result += Math.max(sectionSum1, sectionSum2);
        return (int) (result % MODULO_AMT);
    }
}