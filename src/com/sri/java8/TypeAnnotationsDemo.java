package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Demonstrates the usage of Type Annotations in Java.
 *
 * Type Annotations were introduced in Java 8 to allow annotations to be applied to any use of a type.
 * This includes not only class declarations, but also generic types, casts, and other type uses.
 * Type Annotations can be used for enhanced type checking and error detection.
 */
public class TypeAnnotationsDemo {

    public static void main(String[] args) {
        // 1. Applying Type Annotations to Generic Types
        /**
         * Example 1: Applying a type annotation to a generic type.
         * Type annotations can be used to specify constraints or provide additional information about type usage.
         */
        @NonNull List<String> nonNullList = List.of("Java", "Python", "C++");

        // 2. Applying Type Annotations to Casts
        /**
         * Example 2: Applying a type annotation to a cast.
         * Type annotations can be used to ensure that a specific cast is applied with additional constraints.
         */
        String str = "Hello";
        @NonNull String nonNullStr = (@NonNull String) str;

        // 3. Applying Type Annotations to Method Return Types
        /**
         * Example 3: Applying a type annotation to a method return type.
         * Type annotations can be applied to method return types to provide additional guarantees.
         */
        TypeAnnotationsDemo demo = new TypeAnnotationsDemo();
        @NonNull String result = demo.getGreeting();
        System.out.println(result);
    }

    /**
     * Method that returns a greeting message.
     * The return type is annotated with @NonNull to indicate that the method should not return null.
     *
     * @return a non-null greeting message
     */
    public @NonNull String getGreeting() {
        return "Hello, Java 8!";
    }
}

/**
 * A custom annotation to demonstrate type annotations.
 *
 * @NonNull indicates that the annotated element should not be null.
 */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@interface NonNull {
}

