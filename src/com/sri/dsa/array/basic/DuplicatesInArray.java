package com.sri.dsa.array.basic;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to check for duplicates in an integer array.
 * It leverages a HashSet to track elements and efficiently identify any
 * repetitions,
 * showcasing a common approach to solving the problem of finding duplicates in
 * an array.
 *
 * Usage: This class can be used to detect the presence of duplicates in any
 * integer array
 * provided to the hasDuplicates method.
 * Time Complexity: O(n) where n is the number of elements in the array, due to
 * the single
 * pass through the array.
 * Space Complexity: O(n) in the worst case when all elements are unique, as
 * each element
 * is stored in the HashSet.
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class DuplicatesInArray {
    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 1 }; // Example array with a duplicate
        boolean hasDuplicates = hasDuplicates(array); // Check for duplicates
        System.out.println("Array has duplicates: " + hasDuplicates); // Output the result
    }

    /**
     * This method checks for duplicates in an integer array.
     *
     * @param array An array of integers.
     * @return true if there are duplicates, false otherwise.
     */
    public static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>(); // Create a HashSet to track seen numbers
        for (int num : array) {
            if (seen.contains(num)) {
                return true; // If number is seen before, return true
            }
            seen.add(num); // Add new number to the HashSet
        }
        return false; // Return false if no duplicates found
    }
}
