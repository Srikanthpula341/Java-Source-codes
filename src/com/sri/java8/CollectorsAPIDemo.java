package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates the usage of the Collectors API in Java.
 *
 * The Collectors API provides a variety of reduction operations, such as accumulating elements into collections,
 * summarizing elements according to various criteria, and grouping elements by keys.
 */
public class CollectorsAPIDemo {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "banana");

        // Collecting into a List
        List<String> list = items.stream().collect(Collectors.toList());
        System.out.println("Collected List: " + list);

        // Grouping by value
        Map<String, Long> groupedByCount = items.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println("Grouped by Count: " + groupedByCount);

        // Joining elements
        String joinedString = items.stream().distinct().collect(Collectors.joining(", "));
        System.out.println("Joined String: " + joinedString);
    }
}

