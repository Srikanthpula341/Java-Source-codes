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
 *
 * Functional interfaces are a key concept introduced in Java 8 as part of the
 * lambda expression and functional programming features.
 * A functional interface is an interface that contains exactly one abstract
 * method, but it can have multiple default or static methods.
 * 
 * Functional interfaces serve as the foundation for lambda expressions and
 * method references in Java. They enable developers to write more
 * concise and readable code by allowing the implementation of single-method
 * interfaces in a functional style.
 * 
 * Common functional interfaces in Java include:
 * 
 * 1. `java.util.function.Predicate<T>`:
 * - Represents a function that takes a single input and returns a boolean
 * value.
 * - Example: `Predicate<String> isEmpty = String::isEmpty;`
 *
 * 2. `java.util.function.Function<T, R>`:
 * - Represents a function that takes a single input of type T and returns a
 * result of type R.
 * - Example: `Function<String, Integer> stringLength = String::length;`
 *
 * 3. `java.util.function.Consumer<T>`:
 * - Represents a function that takes a single input and returns no result
 * (void).
 * - Example: `Consumer<String> print = System.out::println;`
 *
 * 4. `java.util.function.Supplier<T>`:
 * - Represents a function that takes no input and returns a result of type T.
 * - Example: `Supplier<String> stringSupplier = () -> "Hello, World!";`
 *
 * 5. `java.util.function.BinaryOperator<T>`:
 * - Represents a function that takes two inputs of the same type and returns a
 * result of the same type.
 * - Example: `BinaryOperator<Integer> sum = (a, b) -> a + b;`
 *
 * A functional interface can also be defined by the developer using the
 * `@FunctionalInterface` annotation. This annotation is not mandatory
 * but is used to explicitly declare an interface as a functional interface. It
 * also ensures that the compiler will generate an error if the
 * interface violates the rules of a functional interface (i.e., having more
 * than one abstract method).
 *
 * Example of a custom functional interface:
 *
 * @FunctionalInterface
 *                      public interface MyFunctionalInterface {
 *                      void execute();
 *
 *                      default void printMessage() {
 *                      System.out.println("Executing functional interface");
 *                      }
 *                      }
 *
 *                      In this example, `MyFunctionalInterface` is a functional
 *                      interface with a single abstract method `execute()`. The
 *                      interface also has a
 *                      default method `printMessage()`, which is allowed in
 *                      functional interfaces.
 *
 *                      Functional interfaces play a crucial role in enabling
 *                      functional programming paradigms in Java, particularly
 *                      with lambda expressions,
 *                      making code more expressive and concise.
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

