package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Demonstrates the usage of CompletableFuture in Java.
 *
 * CompletableFuture is a class that implements the Future interface and allows you to write asynchronous code
 * that is both non-blocking and easier to read.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Asynchronous computation example
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, World!";
        });

        // Do other tasks while waiting for the future to complete
        System.out.println("Doing other tasks...");

        // Get the result of the computation
        String result = future.get();
        System.out.println("Result from CompletableFuture: " + result);
    }
}

