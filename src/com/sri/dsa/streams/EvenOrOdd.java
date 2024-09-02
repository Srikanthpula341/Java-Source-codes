package com.sri.dsa.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;


/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 01-09-2024
 */






/**
 * The EvenOrOdd class demonstrates how to use Java Streams to filter and group
 * even and odd numbers from a list.
 *
 * <p>This class is an example of using the Stream API in Java to efficiently process
 * a list of integers by filtering out even and odd numbers, as well as grouping them
 * into separate categories.
 * </p>
 *
 * <p>
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 * </p>
 *
 * @author Srikanth Pula
 * @date 01-09-2024
 */
public class EvenOrOdd {


    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /**
         * Filters the list to obtain even numbers.
         *
         * <p>
         * This stream operation processes each element of the list, applies a
         * modulus operation to check if the number is even, and collects the
         * even numbers into a new list.
         * </p>
         */
        List<Integer> even = num.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        /**
         * Filters the list to obtain odd numbers.
         *
         * <p>
         * This stream operation processes each element of the list, applies a
         * modulus operation to check if the number is odd, and collects the
         * odd numbers into a new list.
         * </p>
         */
        List<Integer> odd = num.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        /**
         * Groups the numbers into even and odd categories.
         *
         * <p>
         * This stream operation classifies the numbers into two groups: "Even"
         * and "Odd". It uses a lambda expression within the `groupingBy` collector
         * to determine the grouping criteria (whether a number is even or odd).
         * The result is a map where the keys are "Even" and "Odd", and the values
         * are lists of numbers that fall into each category.
         * </p>
         */
        Map<String, List<Integer>> groupedNumbers = num.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        // Print the filtered even numbers
        System.out.println("Even Numbers (Filtered): " + even);

        // Print the filtered odd numbers
        System.out.println("Odd Numbers (Filtered): " + odd);

        // Print the grouped numbers
        System.out.println("Even Numbers (Grouped): " + groupedNumbers.get("Even"));
        System.out.println("Odd Numbers (Grouped): " + groupedNumbers.get("Odd"));
    }
}

