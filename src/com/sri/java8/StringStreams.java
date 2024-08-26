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
 * Demonstrates various Stream API operations with strings.
 */
public class StringStreams {

    public static void main(String[] args) {
        // 1. Stream Creation from List
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        Stream<String> streamFromList = strings.stream();

        // 2. Stream Creation from Array
        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};
        Stream<String> streamFromArray = Arrays.stream(stringArray);

        // 3. Stream Creation using Stream.of
        Stream<String> streamOfStrings = Stream.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        // 4. Stream Creation using Stream.generate (infinite stream)
        Stream<String> generatedStream = Stream.generate(() -> "generated").limit(7);

        // 5. Stream Creation using Stream.iterate
        Stream<String> iteratedStream = Stream.iterate("a", s -> s + "a").limit(7);

        // 6. Filter: Get strings that start with 'a'
        List<String> aStrings = strings.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println("Strings that start with 'a': " + aStrings);

        // 7. Map: Convert strings to uppercase
        List<String> uppercasedStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercased Strings: " + uppercasedStrings);

        // 8. FlatMap: Flatten a stream of lists of characters
        List<String> words = Arrays.asList("hello", "world");
        List<Character> flattenedChars = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Flattened Characters: " + flattenedChars);

        // 9. Sorted: Sort strings by length
        List<String> sortedByLength = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Strings sorted by length: " + sortedByLength);

        // 10. Distinct: Get distinct strings
        List<String> distinctStrings = Arrays.asList("apple", "banana", "apple", "cherry").stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Strings: " + distinctStrings);

        // 11. Limit: Get the first 3 strings
        List<String> limitedStrings = strings.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3 Strings: " + limitedStrings);

        // 12. Skip: Skip the first 2 strings
        List<String> skippedStrings = strings.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Skipped First 2 Strings: " + skippedStrings);

        // 13. Peek: Peek while filtering
        List<String> peekedStrings = strings.stream()
                .filter(s -> s.length() > 5)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("Peeked Strings: " + peekedStrings);

        // 14. TakeWhile: Take strings with length less than 6
        List<String> takenStrings = strings.stream()
                .takeWhile(s -> s.length() < 6)
                .collect(Collectors.toList());
        System.out.println("Taken Strings: " + takenStrings);

        // 15. DropWhile: Drop strings with length less than 6
        List<String> droppedStrings = strings.stream()
                .dropWhile(s -> s.length() < 6)
                .collect(Collectors.toList());
        System.out.println("Dropped Strings: " + droppedStrings);

        // 16. ForEach: Print each string
        System.out.println("ForEach:");
        strings.stream().forEach(System.out::println);

        // 17. Collect to List
        List<String> collectedStrings = strings.stream()
                .collect(Collectors.toList());
        System.out.println("Collected Strings: " + collectedStrings);

        // 18. Collect to Set
        Set<String> collectedSet = strings.stream()
                .collect(Collectors.toSet());
        System.out.println("Collected Set: " + collectedSet);

        // 19. Collect to Map (length as key, string as value)
        Map<Integer, String> collectedMap = strings.stream()
                .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1 + "," + s2));
        System.out.println("Collected Map: " + collectedMap);

        // 20. Reduce: Concatenate all strings
        String concatenatedString = strings.stream()
                .reduce("", String::concat);
        System.out.println("Concatenated String: " + concatenatedString);

        // 21. FindFirst: Find the first string containing 'e'
        Optional<String> firstString = strings.stream()
                .filter(s -> s.contains("e"))
                .findFirst();
        firstString.ifPresent(s -> System.out.println("First String with 'e': " + s));

        // 22. FindAny: Find any string containing 'e'
        Optional<String> anyString = strings.stream()
                .filter(s -> s.contains("e"))
                .findAny();
        anyString.ifPresent(s -> System.out.println("Any String with 'e': " + s));

        // 23. AnyMatch: Check if any string has length greater than 5
        boolean anyMatch = strings.stream()
                .anyMatch(s -> s.length() > 5);
        System.out.println("Any String with length > 5: " + anyMatch);

        // 24. AllMatch: Check if all strings are non-empty
        boolean allMatch = strings.stream()
                .allMatch(s -> !s.isEmpty());
        System.out.println("All Strings are Non-Empty: " + allMatch);

        // 25. NoneMatch: Check if no strings start with 'z'
        boolean noneMatch = strings.stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println("No Strings start with 'z': " + noneMatch);

        // 26. Count: Count strings that contain the letter 'a'
        long count = strings.stream()
                .filter(s -> s.contains("a"))
                .count();
        System.out.println("Count of Strings containing 'a': " + count);

        // 27. ToArray: Convert to array
        String[] array = strings.stream()
                .toArray(String[]::new);
        System.out.println("Array of Strings: " + Arrays.toString(array));

        // 28. GroupingBy: Group strings by length
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        // 29. Joining: Join all strings with a delimiter
        String joinedString = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined String: " + joinedString);

        // 30. SummaryStatistics: Get statistics of string lengths
        IntSummaryStatistics stats = strings.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Summary Statistics:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
    }
}

