package com.sri.dsa.array.sdet;

/**
 *
 *  This class provides a method to sort an array containing elements representing colors.
 *  It uses the Dutch National Flag algorithm to sort the colors in-place, ensuring that all
 *  elements of the same color are grouped together.
 *
 *  Usage: This class can be used to sort an array containing 0s, 1s, and 2s representing colors.
 *  Time Complexity: O(n), where n is the number of elements in the array.
 *  Space Complexity: O(1) since the sorting is done in place without needing additional space.
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 12-06-2024
 */

public class SortColors {
    /**
     * Sorts an array containing elements representing colors (0, 1, and 2) in-place.
     * Using the Dutch National Flag algorithm, it ensures that all elements of the same
     * color are grouped together.
     *
     * @param nums An array of integers representing colors (0, 1, and 2) to be sorted.
     */
    public void sortColors(int[] nums) {
        int start = 0; // Pointer to place the next 0
        int mid = 0; // Current element being examined
        int end = nums.length - 1; // Pointer to place the next 2

        while (mid <= end) {
            if (nums[mid] == 0) {
                // Swap the elements at indices mid and start
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                // Move both pointers forward
                mid++;
                start++;
            } else if (nums[mid] == 1) {
                // If the element is 1, just move the mid pointer forward
                mid++;
            } else {
                // Swap the elements at indices mid and end
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                // Move the end pointer backward
                end--;
            }
        }
    }

    /**
     * Main method for testing the sortColors function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums);
        System.out.println("Sorted Colors: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
