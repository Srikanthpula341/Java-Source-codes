package com.sri.dsa.array.basic;

/**
 * This class provides a method to find the maximum value in an integer array.
 * It demonstrates the basic operation of iterating through an array to identify
 * the largest element, showcasing a common algorithmic problem in computer
 * science.
 *
 * Usage: This class can be used to determine the maximum element of any integer
 * array provided to the findMaximum method.
 * Time Complexity: O(n) where n is the number of elements in the array, because
 * each element is checked exactly once.
 * Space Complexity: O(1) as the additional space used does not depend on the
 * size of the input array.
 *
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class FindMaxMinInArray {
    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 10, 3, 5, 50, 40 }; // Example array
        int max = findMaximum(array); // Calculating the maximum value in the array
        int min = findMinimum(array); // Calculating the minimum value in the array
        System.out.println("Maximum value in the array: " + max); // Output the maximum value
        System.out.println("Minimum value in the array: " + min); // Output the minimum value
    }

    /**
     * This method calculates the maximum value found in an integer array.
     *
     * @param array An array of integers.
     * @return The maximum value from the array elements.
     */
    public static int findMaximum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int max = array[0]; // Initialize max with the first element of the array
        for (int i = 1; i < array.length; i++) { // Start loop from second element
            if (array[i] > max) {
                max = array[i]; // Update max if current element is greater
            }
        }
        return max; // Return the found maximum
    }


      /**
     * This method calculates the minimum value found in an integer array.
     *
     * @param array An array of integers.
     * @return The minimum value from the array elements.
     */
    public static int findMinimum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = array[0]; // Initialize min with the first element of the array
        for (int i = 1; i < array.length; i++) { // Start loop from second element
            if (array[i] < min) {
                min = array[i]; // Update min if current element is less
            }
        }
        return min; // Return the found minimum
    }
}

