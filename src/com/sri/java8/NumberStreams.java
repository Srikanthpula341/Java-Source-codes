package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.*;
import java.util.stream.*;

/**
 * Demonstrates various Stream API operations with numbers.
 */
@SuppressWarnings("unused")
public class NumberStreams {

    
public static void main(String[] args) {
        // 1. Stream Creation from List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamFromList = numbers.stream();

        // 2. Stream Creation from Array
        Integer[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> streamFromArray = Arrays.stream(numberArray);

        // 3. Stream Creation using Stream.of
        Stream<Integer> streamOfNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 4. Stream Creation using Stream.generate (infinite stream)
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(10);

        // 5. Stream Creation using Stream.iterate
        Stream<Integer> iterateNumbers = Stream.iterate(0, n -> n + 2).limit(10);

        // 6. Stream Creation using IntStream.range
        IntStream rangeStream = IntStream.range(1, 11);

        // 7. Stream Creation using IntStream.rangeClosed
        IntStream rangeClosedStream = IntStream.rangeClosed(1, 10);

        // 8. Filter: Get even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // 9. Map: Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared Numbers: " + squaredNumbers);

        // 10. FlatMap: Flatten a stream of lists
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattenedList);

        // 11. Sorted: Sort numbers in descending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted Numbers (Descending): " + sortedNumbers);

        // 12. Distinct: Get distinct numbers
        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5).stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // 13. Limit: Get the first 5 numbers
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First 5 Numbers: " + limitedNumbers);

        // 14. Skip: Skip the first 3 numbers
        List<Integer> skippedNumbers = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Skipped First 3 Numbers: " + skippedNumbers);

        // 15. Peek: Peek while filtering
        List<Integer> peekedNumbers = numbers.stream()
                .filter(n -> n > 5)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("Peeked Numbers: " + peekedNumbers);

        // 16. TakeWhile: Take numbers less than 6
        List<Integer> takenNumbers = numbers.stream()
                .takeWhile(n -> n < 6)
                .collect(Collectors.toList());
        System.out.println("Taken Numbers: " + takenNumbers);

        // 17. DropWhile: Drop numbers less than 6
        List<Integer> droppedNumbers = numbers.stream()
                .dropWhile(n -> n < 6)
                .collect(Collectors.toList());
        System.out.println("Dropped Numbers: " + droppedNumbers);

        // 18. ForEach: Print each number
        System.out.println("ForEach:");
        numbers.stream().forEach(System.out::println);

        // 19. Collect to List
        List<Integer> collectedNumbers = numbers.stream()
                .collect(Collectors.toList());
        System.out.println("Collected Numbers: " + collectedNumbers);

        // 20. Collect to Set
        Set<Integer> collectedSet = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("Collected Set: " + collectedSet);

        // 21. Collect to Map
        Map<Integer, Integer> collectedMap = numbers.stream()
                .collect(Collectors.toMap(n -> n, n -> n * n));
        System.out.println("Collected Map: " + collectedMap);

        // 22. Reduce: Sum all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of Numbers: " + sum);

        // 23. Reduce: Find the maximum number
        int max = numbers.stream()
                .reduce(Integer::max)
                .orElseThrow();
        System.out.println("Max of Numbers: " + max);

        // 24. FindFirst: Find the first number greater than 5
        Optional<Integer> firstNumber = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        firstNumber.ifPresent(n -> System.out.println("First Number > 5: " + n));

        // 25. FindAny: Find any number divisible by 3
        Optional<Integer> anyNumber = numbers.stream()
                .filter(n -> n % 3 == 0)
                .findAny();
        anyNumber.ifPresent(n -> System.out.println("Any Number divisible by 3: " + n));

        // 26. AnyMatch: Check if any number is greater than 8
        boolean anyMatch = numbers.stream()
                .anyMatch(n -> n > 8);
        System.out.println("Any Number > 8: " + anyMatch);

        // 27. AllMatch: Check if all numbers are positive
        boolean allMatch = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("All Numbers are Positive: " + allMatch);

        // 28. NoneMatch: Check if no numbers are negative
        boolean noneMatch = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("No Numbers are Negative: " + noneMatch);

        // 29. Count: Count numbers greater than 5
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Count of Numbers > 5: " + count);

        // 30. ToArray: Convert to array
        Integer[] array = numbers.stream()
                .toArray(Integer[]::new);
        System.out.println("Array of Numbers: " + Arrays.toString(array));

        // 31. MapToInt: Convert stream to IntStream
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        intStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 32. SummaryStatistics: Get statistics of the stream
        IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Summary Statistics:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
    }
}

