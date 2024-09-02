package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates advanced usage of CompletableFuture in Java 8.
 *
 * This example covers nested thenApply, thenCompose, combining futures with thenCombine,
 * handling tasks asynchronously, and more. It showcases how to build complex asynchronous
 * workflows using CompletableFuture.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        // Example 1: Chaining multiple asynchronous tasks with thenApply
        chainTasksExample();

        // Example 2: Using thenCompose for dependent tasks
        thenComposeExample();

        // Example 3: Combining two independent futures using thenCombine
        combineFuturesExample();

        // Example 4: Running tasks asynchronously with thenAccept and thenRun
        thenAcceptAndThenRunExample();

        // Example 5: Handling exceptions with exceptionally and whenComplete
        exceptionHandlingExample(false);
    }

    /**
     * Example 1: Chaining multiple asynchronous tasks using thenApply.
     */
    private static void chainTasksExample() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Task 1: " + Thread.currentThread().getName());
            return 50;
        }).thenApply(result -> {
            System.out.println("Task 2: " + Thread.currentThread().getName());
            return result * 2;
        }).thenApply(result -> {
            System.out.println("Task 3: " + Thread.currentThread().getName());
            return result + 10;
        });

        try {
            System.out.println("Final Result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Example 2: Using thenCompose for dependent tasks.
     */
    private static void thenComposeExample() {
        CompletableFuture<Integer> futureCompose = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Task A: " + Thread.currentThread().getName());
            return 20;
        }).thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task B: " + Thread.currentThread().getName());
            return result * 2;
        }));

        try {
            System.out.println("Compose Result: " + futureCompose.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Example 3: Combining two independent futures using thenCombine.
     */
    private static void combineFuturesExample() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Task C: " + Thread.currentThread().getName());
            return 30;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Task D: " + Thread.currentThread().getName());
            return 40;
        });

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("Combining Task: " + Thread.currentThread().getName());
            return result1 + result2;
        });

        try {
            System.out.println("Combined Result: " + combinedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Example 4: Running tasks asynchronously with thenAccept and thenRun.
     */
    private static void thenAcceptAndThenRunExample() {
        CompletableFuture<Void> futureRun = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Async Task E: " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept(result -> {
            System.out.println("thenAccept: " + result + ", processed in " + Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("thenRun: Task completed in " + Thread.currentThread().getName());
        });

        futureRun.join(); // Wait for the tasks to complete
    }

    /**
     * Example 5: Handling exceptions with exceptionally and whenComplete.
     */
    private static void exceptionHandlingExample(boolean isException) {
        CompletableFuture<Integer> futureException = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Task F: " + Thread.currentThread().getName());
            if (isException) {
                throw new RuntimeException("Intentional Exception");
            }
            return 100;
        }).exceptionally(ex -> {
            System.out.println("Exception Occurred: " + ex.getMessage());
            return -1;
        }).whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Final Result after Exception Handling: " + result);
            } else {
                System.out.println("Task completed exceptionally: " + ex.getMessage());
            }
        });

        futureException.join(); // Wait for the tasks to complete
    }

    /**
     * Utility method to simulate delay in asynchronous tasks.
     *
     * @param seconds Number of seconds to sleep.
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
