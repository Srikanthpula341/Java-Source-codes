package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.*;





public class LambdaExpressions {

    public static void main(String[] args) {
        // 1. Lambda for Runnable
        /*
          Example 1: Creating a Runnable using a Lambda Expression.
          Runnable is a functional interface with a single abstract method run().
          This lambda expression prints "Running a thread".
         */
        Runnable runnable = () -> System.out.println("Running a thread");
        new Thread(runnable).start();

        // 2. Lambda for Comparator
        /*
         * Example 2: Using Lambda for sorting a list with Comparator.
         * Comparator is a functional interface used for comparing two objects.
         * This lambda sorts a list of strings in natural order.
         */
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted List: " + list);

        // 3. Lambda for Predicate (Single Line)
        /*
         * Example 3: Using Lambda for Predicate.
         * Predicate is a functional interface that takes an argument and returns a boolean.
         * This lambda checks if a number is even.
         */
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // 4. Lambda for Predicate (Block)
        /**
         * Example 4: Using Lambda for Predicate with a block of code.
         * This lambda checks if a string is non-null and non-empty.
         */
        Predicate<String> isNotEmpty = s -> {
            return s != null && !s.isEmpty();
        };
        System.out.println("Is 'hello' not empty? " + isNotEmpty.test("hello"));

        // 5. Lambda for Consumer
        /**
         * Example 5: Using Lambda for Consumer.
         * Consumer is a functional interface that takes an argument and performs an operation without returning a result.
         * This lambda converts a string to uppercase and prints it.
         */
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("lambda expressions are cool");

        // 6. Lambda for Function (Single Line)
        /**
         * Example 6: Using Lambda for Function.
         * Function is a functional interface that takes an argument and returns a result.
         * This lambda calculates the length of a string.
         */
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'lambda': " + stringLength.apply("lambda"));

        // 7. Lambda for Function (Block)
        /**
         * Example 7: Using Lambda for Function with a block of code.
         * This lambda calculates the factorial of a number.
         */
        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Factorial of 5: " + factorial.apply(5));

        // 8. Lambda for Supplier
        /**
         * Example 8: Using Lambda for Supplier.
         * Supplier is a functional interface that takes no argument and returns a result.
         * This lambda generates a random number.
         */
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random Value: " + randomValue.get());

        // 9. Lambda for BiFunction
        /**
         * Example 9: Using Lambda for BiFunction.
         * BiFunction is a functional interface that takes two arguments and returns a result.
         * This lambda multiplies two integers.
         */
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiply 5 and 10: " + multiply.apply(5, 10));

        // 10. Lambda for Custom Functional Interface
        /**
         * Example 10: Using Lambda for a Custom Functional Interface.
         * This example shows how to create and use a custom functional interface.
         * The Greetable interface has a single method greet() that takes a name and returns a greeting message.
         */
        Greetable greet = name -> "Hello, " + name;
        System.out.println(greet.greet("Lambda"));

        // 11. Lambda for Stream API
        /**
         * Example 11: Using Lambda with Stream API.
         * This example demonstrates filtering, mapping, and reducing operations on a stream using lambdas.
         * We use a list of integers and perform various operations.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // Map numbers to their squares
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Reduce to sum of squares
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Squares: " + sumOfSquares);
    }

    // Custom Functional Interface
    /**
     * A simple functional interface to demonstrate lambda expressions.
     * The Greetable interface contains a single abstract method greet().
     */
    @FunctionalInterface
    interface Greetable {
        String greet(String name);
    }
}

