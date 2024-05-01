package com.sri.dsa.array.basic;

/**
 * This class provides a method to reverse an integer array.
 * It demonstrates a simple in-place algorithm to reverse the elements of the
 * array.
 *
 * Usage: This class can be used to reverse any integer array provided to the
 * reverse method.
 * Time Complexity: O(n/2) which simplifies to O(n), where n is the number of
 * elements in the array,
 * because each element swap involves two elements, reducing the number of
 * iterations by half.
 * Space Complexity: O(1) since the reversal is done in place without needing
 * extra space for another array.
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class ReverseArray {

    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 }; // Example array
        reverse(array); // Reverse the array
        for (int num : array) {
            System.out.print(num + " "); // Output the reversed array
        }
    }

    /**
     * This method reverses an integer array in place.
     *
     * @param array An array of integers to be reversed.
     */
    public static void reverse(int[] array) {
        int temp, start = 0, end = array.length - 1;
        while (start < end) {
            temp = array[start]; // Store the current element in a temporary variable
            array[start] = array[end]; // Swap the start element with the end element
            array[end] = temp; // Set the end element to the temporary variable
            start++; // Move the start pointer forward
            end--; // Move the end pointer backward
        }
    }
}
