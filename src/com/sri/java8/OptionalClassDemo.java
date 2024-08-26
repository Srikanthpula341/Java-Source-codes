package com.sri.java8;

/*
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.Optional;

/**
 * Demonstrates the usage of the Optional class in Java.
 */
public class OptionalClassDemo {

    public static void main(String[] args) {
        // 1. Creating an Optional
        /**
         * Example 1: Creating an empty Optional.
         * Optional.empty() creates an empty Optional object.
         */
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty Optional: " + emptyOptional);

        /**
         * Example 2: Creating an Optional with a non-null value.
         * Optional.of() creates an Optional containing the provided non-null value.
         */
        Optional<String> nonEmptyOptional = Optional.of("Hello, Optional!");
        System.out.println("Non-Empty Optional: " + nonEmptyOptional);

        /**
         * Example 3: Creating an Optional that may be null.
         * Optional.ofNullable() creates an Optional that can hold a null value.
         * If the value is null, it returns an empty Optional.
         */
        Optional<String> nullableOptional = Optional.ofNullable(null);
        System.out.println("Nullable Optional: " + nullableOptional);

        // 2. Checking if a value is present
        /**
         * Example 4: Checking if a value is present in the Optional.
         * isPresent() returns true if the Optional contains a value, otherwise false.
         */
        if (nonEmptyOptional.isPresent()) {
            System.out.println("Non-Empty Optional contains: " + nonEmptyOptional.get());
        } else {
            System.out.println("Non-Empty Optional is empty");
        }

        // 3. Providing a default value
        /**
         * Example 5: Providing a default value if the Optional is empty.
         * orElse() returns the contained value if present, otherwise returns the provided default value.
         */
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Default Value: " + defaultValue);

        // 4. Executing an action if a value is present
        /**
         * Example 6: Executing an action using ifPresent().
         * ifPresent() executes the given lambda expression if a value is present in the Optional.
         */
        nonEmptyOptional.ifPresent(value -> System.out.println("Value is: " + value));

        // 5. Transforming the value with map()
        /**
         * Example 7: Transforming the value inside an Optional using map().
         * map() applies the given function to the contained value and returns a new Optional with the result.
         */
        Optional<String> upperCaseOptional = nonEmptyOptional.map(String::toUpperCase);
        System.out.println("Uppercase Optional: " + upperCaseOptional);

        // 6. Chaining Optionals with flatMap()
        /**
         * Example 8: Chaining Optionals using flatMap().
         * flatMap() is used when the function returns an Optional itself, to avoid nested Optionals.
         */
        Optional<String> flatMappedOptional = nonEmptyOptional.flatMap(value -> Optional.of(value.toLowerCase()));
        System.out.println("FlatMapped Optional: " + flatMappedOptional);

        // 7. Filtering the value
        /**
         * Example 9: Filtering the value inside an Optional.
         * filter() applies a predicate to the value and returns the same Optional if the predicate is true, otherwise returns an empty Optional.
         */
        Optional<String> filteredOptional = nonEmptyOptional.filter(value -> value.contains("Optional"));
        System.out.println("Filtered Optional: " + filteredOptional);

        // 8. Throwing an exception if value is not present
        /**
         * Example 10: Throwing an exception if the value is not present.
         * orElseThrow() throws the given exception if the Optional is empty.
         */
        try {
            String value = emptyOptional.orElseThrow(() -> new IllegalStateException("Value not found"));
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 9. Optional in a method return type
        /**
         * Example 11: Using Optional as a method return type.
         * This demonstrates how to use Optional as a return type to indicate that a value might be absent.
         */
        Optional<String> optionalValue = findValue("key1");
        optionalValue.ifPresentOrElse(
                value -> System.out.println("Found value: " + value),
                () -> System.out.println("Value not found")
        );
    }

    // Sample method returning an Optional
    /**
     * Simulates a method that may or may not find a value.
     * Returns an Optional containing the value if found, or an empty Optional if not.
     */
    public static Optional<String> findValue(String key) {
        if ("key1".equals(key)) {
            return Optional.of("value1");
        }
        return Optional.empty();
    }
}

