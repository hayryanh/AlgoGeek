package com.algogeek.search;

import java.util.Collections;
import java.util.List;

public final class BinarySearch {

    private BinarySearch() {
    }

    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr.get(mid) == target) {
                return mid; // Target found
            }

            if(arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static int boundarySearch(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundary = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr.get(mid)) {
                boundary = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundary;
    }


    //================ Newspapers ================
    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        // WRITE YOUR BRILLIANT CODE HERE
        int low = Collections.max(newspapersReadTimes);
        int high = 0;
        int ans = -1;
        for (int readTime : newspapersReadTimes)
            high += readTime;
        while (low <= high) {
            int mid = (low + high) / 2;
            // helper function to check if a time works
            if (feasible(newspapersReadTimes, numCoworkers, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean feasible(List<Integer> newspapersReadTimes, int numCoworkers, int limit) {
        // time to keep track of the current worker's time spent, num_workers to keep track of the number of coworkers used
        int time = 0, numWorkers = 0;
        for (int readTime : newspapersReadTimes) {
            // check if the current time exceeds the given time limit
            if (time + readTime > limit) {
                time = 0;
                numWorkers++;
            }
            time += readTime;
        }
        // edge case to check if we needed an extra coworker at the end
        if (time != 0) {
            numWorkers++;
        }
        // check if the number of workers we need is more than what we have
        return numWorkers <= numCoworkers;
    }
}
