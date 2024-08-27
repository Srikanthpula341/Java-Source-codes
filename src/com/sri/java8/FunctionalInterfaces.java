package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.*;
import java.util.function.*;

/**
 * Demonstrates various Functional Interfaces in Java.
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {
        // 1. Predicate Functional Interface
        /**
         * Example 1: Predicate
         * Predicate is a functional interface that takes a single argument and returns a boolean.
         * Commonly used for filtering collections and streams.
         */
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        // 2. Consumer Functional Interface
        /**
         * Example 2: Consumer
         * Consumer is a functional interface that takes a single argument and returns no result.
         * Commonly used to perform operations on objects, like printing or updating values.
         */
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello world");

        // 3. Function Functional Interface
        /**
         * Example 3: Function
         * Function is a functional interface that takes a single argument and returns a result.
         * Commonly used for transforming data, such as converting types or applying operations.
         */
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'FunctionalInterface': " + stringLength.apply("FunctionalInterface"));

        // 4. Supplier Functional Interface
        /**
         * Example 4: Supplier
         * Supplier is a functional interface that takes no arguments and returns a result.
         * Commonly used for generating or providing values, such as random numbers or timestamps.
         */
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random Value: " + randomValue.get());

        // 5. BiFunction Functional Interface
        /**
         * Example 5: BiFunction
         * BiFunction is a functional interface that takes two arguments and returns a result.
         * Commonly used for combining two values into a single result, such as arithmetic operations.
         */
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("5 * 10 = " + multiply.apply(5, 10));

        // 6. UnaryOperator Functional Interface
        /**
         * Example 6: UnaryOperator         *  is a specialized form of Function that takes a single argument and returns a result of the same type.
         * Commonly used for operations like negation, incrementing, or formatting.
         */
        UnaryOperator<Integer> increment = n -> n + 1;
        System.out.println("Increment 5: " + increment.apply(5));

        // 7. BinaryOperator Functional Interface
        /**
         * Example 7: BinaryOperator
         * BinaryOperator is a specialized form of BiFunction that takes two arguments of the same type and returns a result of the same type.
         * Commonly used for operations like addition, finding the maximum, or string concatenation.
         */
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("5 + 10 = " + add.apply(5, 10));

        // 8. Custom Functional Interface
        /**
         * Example 8: Custom Functional Interface
         * This demonstrates how to create and use a custom functional interface.
         * The Converter interface converts a value from one type to another.
         */
        Converter<String, Integer> stringToInteger = Integer::valueOf;
        System.out.println("Converted '123' to " + stringToInteger.convert("123"));

        // 9. Chaining Functional Interfaces
        /**
         * Example 9: Chaining Functional Interfaces
         * This demonstrates chaining functional interfaces to create complex operations.
         * Here, we first apply a function, then a predicate, and finally a consumer.
         */
        Function<String, String> toUpperCase = String::toUpperCase;
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Consumer<String> print = System.out::println;

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        words.stream()
                .map(toUpperCase)
                .filter(startsWithA)
                .forEach(print);
    }

    // Custom Functional Interface
    /**
     * A simple custom functional interface to demonstrate lambda expressions.
     * The Converter interface converts a value from one type to another.
     */
    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }
}

