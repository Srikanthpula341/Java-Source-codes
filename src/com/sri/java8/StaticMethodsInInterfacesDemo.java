package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

/**
 * Demonstrates the usage of static methods in interfaces in Java.
 *
 * Static methods in interfaces are utility methods that belong to the interface itself,
 * not to the instances of the implementing classes. They can be called without creating an
 * instance of the interface.
 */
public class StaticMethodsInInterfacesDemo {

    public static void main(String[] args) {
        // Calling the static method from the interface directly
        StaticMethodInterface.printMessage();

        // Calling another static method to perform a calculation
        int sum = StaticMethodInterface.add(10, 20);
        System.out.println("Sum from StaticMethodInterface.add(10, 20): " + sum);

        // You cannot call the static method from an instance of a class that implements the interface
        StaticMethodImplementation implementation = new StaticMethodImplementation();
        // implementation.printMessage(); // This will cause a compile-time error

        // Call the class's own static method
        StaticMethodImplementation.classStaticMethod();
    }
}

/**
 * StaticMethodInterface is an example interface with static methods.
 *
 * Static methods in interfaces can be used for utility or helper methods.
 * They are not tied to any instance and can only be called using the interface name.
 */
interface StaticMethodInterface {

    /**
     * Static method in the interface.
     * This method can be called without an instance of the interface.
     * It prints a message to the console.
     */
    static void printMessage() {
        System.out.println("This is a static method in StaticMethodInterface.");
    }

    /**
     * Another example of a static method that performs an operation.
     * This method adds two numbers and returns the result.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    static int add(int a, int b) {
        return a + b;
    }
}

/**
 * StaticMethodImplementation is an example class that implements StaticMethodInterface.
 *
 * This class demonstrates how a class that implements an interface can call the
 * interface's static methods within its own methods, but it cannot directly inherit or override them.
 */
class StaticMethodImplementation implements StaticMethodInterface {

    /**
     * This class method calls the static method from the interface.
     * It also prints a custom message and performs a calculation using the interface's static method.
     */
    public static void classStaticMethod() {
        System.out.println("This is a static method in StaticMethodImplementation.");
        System.out.println("Calling static method from StaticMethodInterface:");
        StaticMethodInterface.printMessage();

        int sum = StaticMethodInterface.add(30, 40);
        System.out.println("Sum from StaticMethodInterface.add(30, 40): " + sum);
    }
}

