package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.StringJoiner;

/**
 * Demonstrates the usage of StringJoiner in Java.
 *
 * StringJoiner is a utility class introduced in Java 8 to construct a sequence of characters separated by a delimiter.
 * It also allows for optional prefix and suffix strings.
 */
public class StringJoinerDemo {

    public static void main(String[] args) {
        // Creating a StringJoiner with a delimiter
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("apple");
        joiner.add("banana");
        joiner.add("orange");
        System.out.println("Joined String: " + joiner);

        // Creating a StringJoiner with a delimiter, prefix, and suffix
        StringJoiner joinerWithPrefixSuffix = new StringJoiner(", ", "[", "]");
        joinerWithPrefixSuffix.add("apple");
        joinerWithPrefixSuffix.add("banana");
        joinerWithPrefixSuffix.add("orange");
        System.out.println("Joined String with Prefix and Suffix: " + joinerWithPrefixSuffix);
    }
}

