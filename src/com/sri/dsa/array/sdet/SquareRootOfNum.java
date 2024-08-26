package com.sri.dsa.array.sdet;



/**
 * This class provides a method to compute the integer square root of a number.
 * It demonstrates a simple binary search algorithm to find the integer part of
 * the square root of a non-negative integer.
 *
 * Usage: This class can be used to find the integer square root of any
 * non-negative integer provided to the mySqrt method.
 * Time Complexity: O(log n), where n is the value of the input number,
 * because binary search reduces the search space by half each iteration.
 * Space Complexity: O(1) since the calculation is done in place without needing
 * extra space for additional data structures.
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class SquareRootOfNum {

    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int number = 16; // Example number
        int result = mySqrt(number); // Calculate the integer square root
        System.out.println("The integer square root of " + number + " is: " + result);
    }

    /**
     * This method computes the integer square root of a non-negative integer.
     *
     * @param x A non-negative integer whose integer square root is to be computed.
     * @return The integer square root of the input number.
     */
    public static int mySqrt(int x) {
        if (x < 2) return x; // Handle edge cases where x is 0 or 1

        int left = 1, right = x / 2; // Initialize binary search bounds

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid to avoid overflow
            long midSquared = (long) mid * mid; // Compute mid^2 using long to prevent overflow

            if (midSquared == x) {
                return mid; // Exact integer square root found
            } else if (midSquared < x) {
                left = mid + 1; // Move left boundary to mid + 1
            } else {
                right = mid - 1; // Move right boundary to mid - 1
            }
        }

        return right; // Right is the integer part of the square root
    }
}
