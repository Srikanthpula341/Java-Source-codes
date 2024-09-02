package com.sri.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDemo {

  public static void main(String[] args) {

    List<Student> studentList = new ArrayList<>();

    studentList.add(new Student(1, "Srikanth", "Mechanical", "Hyderabad", Arrays.asList("1234567890", "0987654321")));
    studentList.add(new Student(2, "Ravi", "Computer Science", "Bangalore", Arrays.asList("1234567891", "0987654322")));
    studentList.add(new Student(3, "Kiran", "Electrical", "Chennai", Arrays.asList("1234567892", "0987654323")));
    studentList.add(new Student(4, "Priya", "Civil", "Mumbai", Arrays.asList("1234567893", "0987654324")));
    studentList.add(new Student(5, "Aditi", "Electronics", "Pune", Arrays.asList("1234567894", "0987654325")));
    studentList.add(new Student(6, "Rohit", "Mechanical", "Delhi", Arrays.asList("1234567895", "0987654326")));
    studentList
        .add(new Student(7, "Anusha", "Computer Science", "Hyderabad", Arrays.asList("1234567896", "0987654327")));
    studentList.add(new Student(8, "Vijay", "Electrical", "Bangalore", Arrays.asList("1234567897", "0987654328")));
    studentList.add(new Student(9, "Nikhil", "Civil", "Chennai", Arrays.asList("1234567898", "0987654329")));
    studentList.add(new Student(10, "Meghana", "Electronics", "Mumbai", Arrays.asList("1234567899", "0987654330")));
    studentList.add(new Student(11, "Suresh", "Mechanical", "Pune", Arrays.asList("1234567800", "0987654331")));
    studentList
        .add(new Student(12, "Samantha", "Computer Science", "Delhi", Arrays.asList("1234567801", "0987654332")));
    studentList.add(new Student(13, "Harsha", "Electrical", "Hyderabad", Arrays.asList("1234567802", "0987654333")));
    studentList.add(new Student(14, "Deepika", "Civil", "Bangalore", Arrays.asList("1234567803", "0987654334")));
    studentList.add(new Student(15, "Akhil", "Electronics", "Chennai", Arrays.asList("1234567804", "0987654335")));
    studentList.add(new Student(16, "Madhavi", "Mechanical", "Mumbai", Arrays.asList("1234567805", "0987654336")));
    studentList.add(new Student(17, "Raj", "Computer Science", "Pune", Arrays.asList("1234567806", "0987654337")));
    studentList.add(new Student(18, "Kavya", "Electrical", "Delhi", Arrays.asList("1234567807", "0987654338")));
    studentList.add(new Student(19, "Sumanth", "Civil", "Hyderabad", Arrays.asList("1234567808", "0987654339")));
    studentList.add(new Student(20, "Bhavya", "Electronics", "Bangalore", Arrays.asList("1234567809", "0987654340")));





    

    // 1. Filter the students from the "Computer Science" department.
    List<String> csStudents = studentList.stream()
        .filter(s -> s.getDept().equals("Computer Science"))
        .map(Student::getName)
        .collect(Collectors.toList());
    System.out.println("Computer Science Students: " + csStudents);

    // 2. Get a list of all student names
    List<String> studentNameList = studentList.stream()
        .map(Student::getName)
        .collect(Collectors.toList());
    System.out.println("All Student Names: " + studentNameList);

    // 3. Find the student with the highest ID
    Student s1 = studentList.stream()
        .max(Comparator.comparing(Student::getId))
        .orElse(null);
    System.out.println("Student with the Highest ID: " + s1);

    // 4. Sort students by their ID in ascending order
    List<Student> sortedById = studentList.stream()
        .sorted(Comparator.comparingInt(Student::getId))
        .collect(Collectors.toList());
    System.out.println("\nStudents Sorted by ID:");
    sortedById.forEach(System.out::println);

    // 4. Sort students by their ID in reverse order
    List<Student> sortedByIdReverse = studentList.stream()
        .sorted(Comparator.comparingInt(Student::getId).reversed())
        .collect(Collectors.toList());

    System.out.println("\nStudents Sorted by ID in Reverse Order:");
    sortedByIdReverse.forEach(System.out::println);

    // 5. Check if all students are from the city "Hyderabad"
    boolean allFromHyderabad = studentList.stream()
        .allMatch(student -> "Hyderabad".equals(student.getCity()));
    System.out.println("\nAll students from Hyderabad: " + allFromHyderabad);

    // 6. Group students by their department
    System.out.println("\nStudents Grouped by Department:");
    studentList.stream()
        .collect(Collectors.groupingBy(Student::getDept))
        .forEach((dept, students) -> {
          System.out.println(dept + ":");
          students.forEach(System.out::println);
        });

    // 7. Find any student from the "Electronics" department
    Student anyElectronicsStudent = studentList.stream()
        .filter(student -> "Electronics".equals(student.getDept()))
        .findAny()
        .orElse(null);
    System.out.println("\nAny Electronics Student: " + anyElectronicsStudent);

    // 8. Count the number of students in the "Mechanical" department
    long mechStudentsCount = studentList.stream()
        .filter(student -> "Mechanical".equals(student.getDept()))
        .count();
    System.out.println("\nNumber of Mechanical Students: " + mechStudentsCount);

    // 9. Get the maximum student ID
    int maxId = studentList.stream()
        .mapToInt(Student::getId)
        .max()
        .orElse(-1);
    System.out.println("\nMaximum Student ID: " + maxId);

    // 10. Create a comma-separated string of all student cities
    String cities = studentList.stream()
        .map(Student::getCity)
        .distinct()
        .collect(Collectors.joining(", "));
    System.out.println("\nCities: " + cities);

    // 11. Find the student with the lowest ID
    Student lowestIdStudent = studentList.stream()
        .min(Comparator.comparingInt(Student::getId))
        .orElse(null);
    System.out.println("\nStudent with Lowest ID: " + lowestIdStudent);

    // 12. Skip the first 5 students and process the rest
    List<Student> skippedFirstFive = studentList.stream()
        .skip(5)
        .collect(Collectors.toList());
    System.out.println("\nStudents after skipping first 5:");
    skippedFirstFive.forEach(System.out::println);

    // 13. Limit the stream to only 10 students
    List<Student> limitedToTen = studentList.stream()
        .limit(10)
        .collect(Collectors.toList());
    System.out.println("\nFirst 10 Students:");
    limitedToTen.forEach(System.out::println);

    // 14. Partition students into two groups based on ID < 10
    System.out.println("\nPartitioned Students by ID < 10:");
    studentList.stream()
        .collect(Collectors.partitioningBy(student -> student.getId() < 10))
        .forEach((isLessThan10, students) -> {
          System.out.println((isLessThan10 ? "ID < 10: " : "ID >= 10: "));
          students.forEach(System.out::println);
        });

    // 15. Collect all distinct phone numbers from all students
    List<String> distinctPhones = studentList.stream()
        .flatMap(student -> student.getPhones().stream())
        .distinct()
        .collect(Collectors.toList());
    System.out.println("\nDistinct Phone Numbers:");
    distinctPhones.forEach(System.out::println);

    // 16. Count the total number of phone numbers across all students
    long totalPhoneCount = studentList.stream()
        .flatMap(student -> student.getPhones().stream())
        .count();
    System.out.println("\nTotal Number of Phone Numbers: " + totalPhoneCount);

    // 17. Collect students into a map where the key is the student ID
    System.out.println("\nStudent Map:");
    studentList.stream()
        .collect(Collectors.toMap(Student::getId, student -> student))
        .forEach((id, student) -> System.out.println("ID: " + id + " -> " + student));

    // 18. Create a summary of student IDs (count, sum, min, average, max)
    System.out.println("\nID Summary: ");
    studentList.stream()
        .mapToInt(Student::getId)
        .summaryStatistics()
        .toString();

    // 19. Get a list of students who have more than 1 phone numbers
    List<Student> studentsWithMoreThanTwoPhones = studentList.stream()
        .filter(student -> student.getPhones().size() > 1)
        .collect(Collectors.toList());
    System.out.println("\nStudents with more than 1 phones:");
    studentsWithMoreThanTwoPhones.forEach(System.out::println);

    // 20. Find the average student ID of students in the "Computer Science"
    // department
    double averageIdCS = studentList.stream()
        .filter(student -> "Computer Science".equals(student.getDept()))
        .mapToInt(Student::getId)
        .average()
        .orElse(-1);
    System.out.println("\nAverage ID of Computer Science Students: " + averageIdCS);
  }
}
