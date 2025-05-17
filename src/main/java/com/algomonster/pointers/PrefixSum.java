package com.algomonster.pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class PrefixSum {

    private PrefixSum() {
    }

    /**
     * Find the starting and ending indices of a subarray with a given sum.
     * <p>
     * The sum of elements from index 0 to i is called the prefix sum (prefix = from the beginning,
     * prefix sum = sum from the beginning, i.e., index 0). If we have the prefix sum for each index,
     * we can find the sum of any subarray in constant time.
     * </p>
     * <p>
     * With the knowledge of the prefix sum under our belt, the problem boils down to Two Sum.
     * We keep a dictionary of prefix_sum: index while going through the array calculating prefix_sum.
     * If at any point, prefix_sum - target is in the dictionary, we have found our subarray.
     * </p>
     */
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // prefix_sum 0 happens when we have an empty array
        prefixSums.put(0, 0);
        int curSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                return List.of(prefixSums.get(complement), i + 1);
            }
            prefixSums.put(curSum, i + 1);
        }


        return List.of();
    }

    /**
     * Find the total number of subarrays with a given sum.
     * <p>
     * This is a variation of the subarray sum problem where we need to find all subarrays that sum to a
     * given target. We can use the same prefix sum approach as above, but instead of returning the first
     * subarray we find, we count all subarrays that sum to the target.
     * </p>
     *
     * @param arr    the list of integers
     * @param target the target sum
     * @return the total number of subarrays that sum to the target
     */
    public static int subarraySumTotal(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); // since empty array's sum is 0
        int curSum = 0;
        int count = 0;
        for (int val : arr) {
            curSum += val;
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                count += prefixSums.get(complement);
            }
            if (prefixSums.containsKey(curSum)) {
                prefixSums.replace(curSum, prefixSums.get(curSum) + 1);
            } else {
                prefixSums.put(curSum, 1);
            }
        }
        return count;
    }

    /**
     * Find the sum of elements in a range.
     * <p>
     * This is a variation of the prefix sum problem where we need to find the sum of elements in a
     * given range. We can use the prefix sum array to find the sum of elements in a given range
     * in constant time.
     * </p>
     *
     * @param nums  the list of integers
     * @param left  the left index of the range
     * @param right the right index of the range
     * @return the sum of elements in the range [left, right]
     */
    public static int rangeSumQueryImmutable(List<Integer> nums, int left, int right) {
        int[] prefixSum = new int[nums.size() + 1];
        for (int i = 0; i < nums.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }

        return prefixSum[right + 1] - prefixSum[left];
    }

    /**
     * Find the product of all elements in an array except self.
     * <p>
     * This is a variation of the prefix sum problem where we need to find the product of all
     * elements in an array except the current element. We can use the prefix product array to find
     * the product of all elements in an array except the current element in constant time.
     * </p>
     * @param nums the list of integers
     * @return the list of products of all elements except self
     */
    public static List<Integer> productOfArrayExceptSelf(List<Integer> nums) {
        int length = nums.size();
        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            result.add(0);
        }

        int left = 1;
        for (int i = 0; i < length; i++) {
            result.set(i, left);
            left *= nums.get(i);
        }

        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            result.set(i, result.get(i) * right);
            right *= nums.get(i);
        }

        return result;
    }
}
