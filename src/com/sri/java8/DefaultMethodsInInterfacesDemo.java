package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

/**
 * Demonstrates the usage of default methods in interfaces in Java.
 *
 * Default methods allow interfaces to have methods with a default implementation.
 * Implementing classes can use these methods as-is or override them to provide
 * their own specific implementation.
 */
public class DefaultMethodsInInterfacesDemo {

    public static void main(String[] args) {
        // Creating an instance of the implementation class
        DefaultMethodImplementation implementation = new DefaultMethodImplementation();

        // Calling the abstract method implemented in the implementation class
        implementation.abstractMethod();

        // Calling the default method provided by the interface
        implementation.defaultMethod();

        // Calling the static method from the interface directly
        DefaultMethodInterface.staticMethod();
    }
}

/**
 * DefaultMethodInterface is an example interface with an abstract method,
 * a default method, and a static method.
 *
 * The default method provides a common implementation that can be shared
 * across all implementing classes. However, classes can override this method
 * to customize its behavior.
 */
interface DefaultMethodInterface {

    /**
     * Abstract method that must be implemented by any class that implements this interface.
     * This method does not have a body and must be provided by the implementing class.
     */
    void abstractMethod();

    /**
     * Default method that provides a standard implementation.
     * Implementing classes can use this method as-is or override it.
     */
    default void defaultMethod() {
        System.out.println("This is the default method in DefaultMethodInterface.");
    }

    /**
     * Static method in the interface.
     * Static methods in interfaces can be called without an instance of the interface.
     * They are not inherited by the implementing classes.
     */
    static void staticMethod() {
        System.out.println("This is a static method in DefaultMethodInterface.");
    }
}

/**
 * DefaultMethodImplementation is an example class that implements DefaultMethodInterface.
 *
 * This class provides its own implementation of the abstract method, and optionally,
 * it can override the default method to provide a custom implementation.
 */
class DefaultMethodImplementation implements DefaultMethodInterface {

    /**
     * Implementation of the abstract method from DefaultMethodInterface.
     * This method is mandatory to implement because it's abstract in the interface.
     */
    @Override
    public void abstractMethod() {
        System.out.println("This is the implementation of the abstract method in DefaultMethodImplementation.");
    }

    /**
     * Override the default method from DefaultMethodInterface.
     * This is optional. If not overridden, the default implementation will be used.
     */
    @Override
    public void defaultMethod() {
        System.out.println("This is the overridden default method in DefaultMethodImplementation.");
    }
}

