package com.sri.dsa.array.basic;

import java.util.Arrays;

/**
 * This class provides methods to rotate the elements of an array to the right
 * or left
 * by a specified number of positions. The rotation is done in place, minimizing
 * space usage.
 *
 * Usage: This class can be used to rotate any integer array. Specify the number
 * of positions
 * and the direction (right or left) in the rotate method.
 * Time Complexity: O(n), where n is the number of elements in the array, as
 * each element is
 * moved exactly once.
 * Space Complexity: O(1) because the rotation is performed in place.
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class RotateArray {

    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5,6,7,8,9,10 }; // Example array
        int k = 3; // Number of positions to rotate by
        // Rotate array to the right
        rotateRight(array, k);
        System.out.print("Array rotated to the right by " + k + " positions: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Reset array for demonstration
        int[] originalArray = { 1, 2, 3, 4, 5,6,7,8,9,10 };
        // Rotate array to the left
        rotateLeft(originalArray, k);
        System.out.print("Array rotated to the left by " + k + " positions: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
    }

    /**
     * Rotates the array to the right by the specified number of positions.
     *
     * @param array The array to be rotated.
     * @param k     The number of positions to rotate the array by.
     */
    public static void rotateRight(int[] array, int k) {
        if (array == null || k < 0) {
            throw new IllegalArgumentException(
                    "The array cannot be null and the number of positions must be non-negative.");
        }
        int n = array.length;
        k = k % n; // Handle rotations greater than the length of the array
        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
    }

    /**
     * Rotates the array to the left by the specified number of positions.
     *
     * @param array The array to be rotated.
     * @param k     The number of positions to rotate the array by.
     */
    public static void rotateLeft(int[] array, int k) {
        if (array == null || k < 0) {
            throw new IllegalArgumentException(
                    "The array cannot be null and the number of positions must be non-negative.");
        }
        int n = array.length;
        k = k % n; // Handle rotations greater than the length of the array
        reverse(array, 0, n - 1);
        reverse(array, 0, n - k - 1);
        reverse(array, n - k, n - 1);
    }

    /**
     * Helper method to reverse the elements of the array between two indices.
     *
     * @param array The array to be reversed.
     * @param start The starting index of the range to reverse.
     * @param end   The ending index of the range to reverse.
     */
    private static void reverse(int[] array, int start, int end) {
        while (start < end) {

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
            System.out.println(Arrays.toString(array)+" "+start+" "+end);
        }
    }
}
