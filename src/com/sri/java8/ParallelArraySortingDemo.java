package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.Arrays;

/**
 * Demonstrates the usage of Parallel Array Sorting in Java.
 *
 * Parallel Array Sorting is a feature introduced in Java 8 that allows arrays
 * to be sorted using multiple threads. This can result in faster sorting times
 * for large arrays by leveraging multiple CPU cores.
 */
public class ParallelArraySortingDemo {

    public static void main(String[] args) {
        // 1. Example of parallel sorting for an integer array
        /**
         * Example 1: Sorting an integer array using parallelSort().
         * parallelSort() divides the array into smaller parts and sorts them in parallel,
         * then merges the results back together.
         */
        int[] numbers = {5, 9, 1, 10, 3, 7, 4, 6, 2, 8};
        System.out.println("Before Parallel Sort: " + Arrays.toString(numbers));

        Arrays.parallelSort(numbers);

        System.out.println("After Parallel Sort: " + Arrays.toString(numbers));

        // 2. Example of parallel sorting for a portion of an array
        /**
         * Example 2: Sorting a specific range within an array using parallelSort().
         * You can specify a start and end index to only sort a portion of the array.
         */
        int[] moreNumbers = {15, 3, 20, 8, 5, 12, 18, 7, 10, 14};
        System.out.println("Before Partial Parallel Sort: " + Arrays.toString(moreNumbers));

        Arrays.parallelSort(moreNumbers, 2, 8);

        System.out.println("After Partial Parallel Sort: " + Arrays.toString(moreNumbers));

        // 3. Example of parallel sorting for a string array
        /**
         * Example 3: Sorting a string array using parallelSort().
         * parallelSort() can be used with any array type, including arrays of objects like strings.
         */
        String[] words = {"banana", "apple", "grape", "cherry", "mango", "blueberry"};
        System.out.println("Before Parallel Sort: " + Arrays.toString(words));

        Arrays.parallelSort(words);

        System.out.println("After Parallel Sort: " + Arrays.toString(words));
    }
}

