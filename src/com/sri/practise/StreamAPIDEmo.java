// package com.sri.practise;

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// /**
// * Copyright (c) 2024 Srikanth Pula. All rights reserved.
// *
// * @author Srikanth Pula
// * Date: 29-08-2024
// */


// class User {
//    public String name;
//    public int age;
//    public List<String> phoneNumbers;

//    public User() {

//    }

//    public User(String name, int age, List<String> phoneNumbers) {
//        this.name = name;
//        this.age = age;
//        this.phoneNumbers = phoneNumbers;
//    }

//    @Override
//    public String toString() {
//        return "User{name='" + name + "', age=" + age + ", phoneNumbers=" + phoneNumbers + '}';
//    }
// }

// public class StreamAPIDEmo {


//    public static void main(String[] args) {

//       List<User> users = Stream.of(
//            new User("John", 30, List.of("1234567890", "9876543210")),
//            new User("Jane", 25, List.of("9876543210", "1234567890"))
//       ).toList();

//         System.out.println(Arrays.toString(users.toArray()));




//    }

//    public String reverseVowels(String s) {

//        int left = 0;
//        int right = s.length();

//        while (left < right) {

//            char ch1 = s.charAt(left);
//            char ch2 = s.charAt(right);

//            if(isVowel(ch1))


//        }

//        return s;
//    }

//    public boolean isVowel ( char ch){
//        return (ch =='a' || ch =='e'|| ch =='i'|| ch =='o'|| ch =='u');
//    }
// }




