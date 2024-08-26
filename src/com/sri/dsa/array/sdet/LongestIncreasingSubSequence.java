package com.sri.dsa.array.sdet;

import java.util.Arrays;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 25-08-2024
 */

public class LongestIncreasingSubSequence {

    public static int lengthOfLIS(int[] arr) {
        if (arr.length == 0) return 0;

        int[] lis = new int[arr.length];
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int pos = Arrays.binarySearch(lis, 0, maxLen, arr[i]);
            if (pos < 0) pos = -(pos + 1);
            lis[pos] = arr[i];
            if (pos == maxLen) maxLen++;
        }

        return maxLen;
    }

    public static void main(String[] args) {


        // Example 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Output: " + lengthOfLIS(nums1)); // Should print 4

        // Example 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Output: " + lengthOfLIS(nums2)); // Should print 4

        // Example 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Output: " + lengthOfLIS(nums3)); // Should print 1
    }


}
