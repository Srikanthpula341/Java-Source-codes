package com.sri.dsa.streams;
import java.util.*;

/**
 * The SquareOfNumbers class demonstrates how to use Java Streams to calculate the square
 * of each number in a list.
 *
 * <p>This class is an example of using the Stream API in Java to process a list of integers,
 * applying a mapping function to compute the square of each number and collect the results
 * into a new list.
 * </p>
 *
 * <p>
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 * </p>
 *
 * @author Srikanth Pula
 * Date: 01-09-2024
 */
public class SquareOfNumbers {

    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*
         * Computes the square of each number in the list.
         *
         * <p>
         * This stream operation processes each element of the list, applying a mapping
         * function to calculate the square of each number. The resulting squares are
         * collected into a new list.
         * </p>
         */
        List<Integer> squares = num.stream()
                .map(n -> n * n)
                .toList();

        // Print the list of squares
        System.out.println("Squares of the numbers: " + squares);
    }
}
