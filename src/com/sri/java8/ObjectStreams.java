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
 * Demonstrates various Stream API operations with custom objects.
 */
@SuppressWarnings("unused")
public class ObjectStreams {

    static class Person {
        String name;
        int age;
        String city;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        @Override
        public String toString() {
            return name + " (" + age + ", " + city + ")";
        }
    }

    public static void main(String[] args) {
        // List of People
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "New York"),
                new Person("Bob", 20, "Los Angeles"),
                new Person("Charlie", 25, "Chicago"),
                new Person("David", 35, "New York"),
                new Person("Eve", 28, "San Francisco"),
                new Person("Frank", 40, "Los Angeles"),
                new Person("Grace", 33, "Chicago")
        );

        // 1. Stream Creation from List
        Stream<Person> streamFromList = people.stream();

        // 2. Stream Creation from Array
        Person[] personArray = {
                new Person("Henry", 45, "Miami"),
                new Person("Irene", 22, "Boston")
        };
        Stream<Person> streamFromArray = Arrays.stream(personArray);

        // 3. Stream Creation using Stream.of
        Stream<Person> streamOfPeople = Stream.of(
                new Person("Jack", 29, "Seattle"),
                new Person("Karen", 32, "Austin")
        );

        // 4. Filter: Get people older than 30
        List<Person> olderThan30 = people.stream()
                .filter(p -> p.age > 30)
                .collect(Collectors.toList());
        System.out.println("People older than 30: " + olderThan30);

        // 5. Map: Get a list of names
        List<String> names = people.stream()
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("Names: " + names);

        // 6. FlatMap: Get a list of all cities (from a list of lists)
        List<List<String>> cityLists = Arrays.asList(
                Arrays.asList("New York", "Los Angeles"),
                Arrays.asList("Chicago", "Miami"),
                Arrays.asList("San Francisco", "Austin")
        );
        List<String> flattenedCities = cityLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened Cities: " + flattenedCities);

        // 7. Sorted: Sort people by age
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .collect(Collectors.toList());
        System.out.println("People sorted by age: " + sortedByAge);

        // 8. Distinct: Get distinct cities
        List<String> distinctCities = people.stream()
                .map(p -> p.city)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Cities: " + distinctCities);

        // 9. Limit: Get the first 3 people
        List<Person> limitedPeople = people.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3 People: " + limitedPeople);

        // 10. Skip: Skip the first 2 people
        List<Person> skippedPeople = people.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Skipped First 2 People: " + skippedPeople);

        // 11. Peek: Peek while filtering
        List<Person> peekedPeople = people.stream()
                .filter(p -> p.age > 25)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("Peeked People: " + peekedPeople);

        // 12. TakeWhile: Take people younger than 35
        List<Person> takenPeople = people.stream()
                .takeWhile(p -> p.age < 35)
                .collect(Collectors.toList());
        System.out.println("Taken People: " + takenPeople);

        // 13. DropWhile: Drop people younger than 35
        List<Person> droppedPeople = people.stream()
                .dropWhile(p -> p.age < 35)
                .collect(Collectors.toList());
        System.out.println("Dropped People: " + droppedPeople);

        // 14. ForEach: Print each person
        System.out.println("ForEach:");
        people.stream().forEach(System.out::println);

        // 15. Collect to List
        List<Person> collectedPeople = people.stream()
                .collect(Collectors.toList());
        System.out.println("Collected People: " + collectedPeople);

        // 16. Collect to Set (by cities)
        Set<String> collectedCities = people.stream()
                .map(p -> p.city)
                .collect(Collectors.toSet());
        System.out.println("Collected Cities: " + collectedCities);

        // 17. Collect to Map (name as key, person as value)
        Map<String, Person> collectedMap = people.stream()
                .collect(Collectors.toMap(p -> p.name, p -> p));
        System.out.println("Collected Map: " + collectedMap);

        // 18. Reduce: Get the oldest person
        Optional<Person> oldestPerson = people.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2);
        oldestPerson.ifPresent(p -> System.out.println("Oldest Person: " + p));

        // 19. FindFirst: Find the first person older than 25
        Optional<Person> firstPerson = people.stream()
                .filter(p -> p.age > 25)
                .findFirst();
        firstPerson.ifPresent(p -> System.out.println("First Person older than 25: " + p));

        // 20. FindAny: Find any person younger than 30
        Optional<Person> anyPerson = people.stream()
                .filter(p -> p.age < 30)
                .findAny();
        anyPerson.ifPresent(p -> System.out.println("Any Person younger than 30: " + p));

        // 21. AnyMatch: Check if any person is named "Alice"
        boolean anyMatch = people.stream()
                .anyMatch(p -> p.name.equals("Alice"));
        System.out.println("Any Person named Alice: " + anyMatch);

        // 22. AllMatch: Check if all people are older than 18
        boolean allMatch = people.stream()
                .allMatch(p -> p.age > 18);
        System.out.println("All People older than 18: " + allMatch);

        // 23. NoneMatch: Check if no person is named "Frank"
        boolean noneMatch = people.stream()
                .noneMatch(p -> p.name.equals("Frank"));
        System.out.println("No Person named Frank: " + noneMatch);

        // 24. Count: Count people younger than 30
        long count = people.stream()
                .filter(p -> p.age < 30)
                .count();
        System.out.println("Count of People younger than 30: " + count);

        // 25. ToArray: Convert to array
        Person[] personArrayResult = people.stream()
                .toArray(Person[]::new);
        System.out.println("Array of People: " + Arrays.toString(personArrayResult));

        // 26. GroupingBy: Group people by city
        Map<String, List<Person>> groupedByCity = people.stream()
                .collect(Collectors.groupingBy(p -> p.city));
        System.out.println("Grouped by City: " + groupedByCity);

        // 27. PartitioningBy: Partition people by age > 30
        Map<Boolean, List<Person>> partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.age > 30));
        System.out.println("Partitioned by Age > 30: " + partitionedByAge);

        // 28. Joining: Join all names with a delimiter
        String joinedNames = people.stream()
                .map(p -> p.name)
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);

        // 29. Mapping: Map names to a new List
        List<String> nameList = people.stream()
                .collect(Collectors.mapping(p -> p.name, Collectors.toList()));
        System.out.println("Mapped Names: " + nameList);

        // 30. SummaryStatistics: Get statistics of ages
        IntSummaryStatistics ageStats = people.stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println("Age Summary Statistics:");
        System.out.println("Count: " + ageStats.getCount());
        System.out.println("Sum: " + ageStats.getSum());
        System.out.println("Min: " + ageStats.getMin());
        System.out.println("Average: " + ageStats.getAverage());
        System.out.println("Max: " + ageStats.getMax());
    }
}
