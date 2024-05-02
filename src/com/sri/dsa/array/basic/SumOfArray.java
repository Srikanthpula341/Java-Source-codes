package com.sri.dsa.array.basic;

/**
 * This class provides a method to calculate the sum of all elements in an
 * integer array.
 * It demonstrates a straightforward approach to aggregate values in a
 * collection.
 *
 * Usage: This class can be used to compute the total sum of elements in any
 * integer array
 * provided to the sumArray method.
 * Time Complexity: O(n), where n is the number of elements in the array, as
 * each element
 * is processed once.
 * Space Complexity: O(1), as the sum is stored in a single variable and no
 * additional storage
 * is used.
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class SumOfArray {

    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 }; // Example array
        int sum = sumArray(array); // Calculate the sum of the array
        System.out.println("Sum of array elements: " + sum); // Output the result
    }

    /**
     * This method calculates the sum of all elements in an integer array.
     *
     * @param array An array of integers.
     * @return The sum of the elements in the array.
     */
    public static int sumArray(int[] array) {
        int sum = 0; // Initialize sum to zero
        for (int num : array) {
            sum += num; // Add each element to sum
        }
        return sum; // Return the total sum
    }
}
