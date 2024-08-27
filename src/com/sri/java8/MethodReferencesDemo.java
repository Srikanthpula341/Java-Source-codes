package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the usage of Method References in Java.
 *
 * Method references are a shorthand notation for calling a method via a lambda expression.
 * They allow you to refer to methods directly by their names and can be used in place of
 * a lambda expression to make the code more readable.
 */
public class MethodReferencesDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

        // 1. Reference to a static method
        /**
         * Example 1: Reference to a static method.
         * The method 'printName' is a static method, and it is referenced using the
         * class name followed by '::' and the method name.
         */
        names.forEach(MethodReferencesDemo::printName);

        // 2. Reference to an instance method of a particular object
        /**
         * Example 2: Reference to an instance method of a particular object.
         * The method 'toUpperCase' is an instance method of the String class.
         * Here, it is referenced using an instance of the String class followed by '::'.
         */
        names.forEach(String::toUpperCase);

        // 3. Reference to an instance method of an arbitrary object of a particular type
        /**
         * Example 3: Reference to an instance method of an arbitrary object of a particular type.
         * The method 'printInUpperCase' is an instance method of MethodReferencesDemo.
         * Here, it is referenced using an instance of the class followed by '::'.
         */
        MethodReferencesDemo demo = new MethodReferencesDemo();
        names.forEach(demo::printInUpperCase);

        // 4. Reference to a constructor
        /**
         * Example 4: Reference to a constructor.
         * Here, the constructor of the StringBuilder class is referenced.
         * This is used to create new instances of StringBuilder in a stream operation.
         */
        List<StringBuilder> builders = names.stream()
                .map(StringBuilder::new)
                .toList();
        builders.forEach(System.out::println);
    }

    /**
     * A static method that prints a name.
     * This method is used in the method reference example 1.
     *
     * @param name the name to be printed
     */
    public static void printName(String name) {
        System.out.println(name);
    }

    /**
     * An instance method that prints a name in uppercase.
     * This method is used in the method reference example 3.
     *
     * @param name the name to be printed in uppercase
     */
    public void printInUpperCase(String name) {
        System.out.println(name.toUpperCase());
    }
}

