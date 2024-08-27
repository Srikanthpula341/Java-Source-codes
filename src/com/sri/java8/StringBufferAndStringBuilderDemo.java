package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

/**
 * Demonstrates the usage of all key methods in StringBuffer and StringBuilder classes in Java.
 *
 * StringBuffer and StringBuilder are used for creating mutable (modifiable) strings.
 * StringBuffer is thread-safe (synchronized), whereas StringBuilder is not, making StringBuilder faster in single-threaded contexts.
 */
public class StringBufferAndStringBuilderDemo {

    public static void main(String[] args) {
        // 1. StringBuffer Example
        System.out.println("StringBuffer Example:");
        StringBuffer sb = new StringBuffer("Hello");

        // append()
        sb.append(" World");
        System.out.println("append(): " + sb);

        // insert()
        sb.insert(5, ",");
        System.out.println("insert(): " + sb);

        // replace()
        sb.replace(6, 7, "-");
        System.out.println("replace(): " + sb);

        // delete()
        sb.delete(5, 6);
        System.out.println("delete(): " + sb);

        // deleteCharAt()
        sb.deleteCharAt(5);
        System.out.println("deleteCharAt(): " + sb);

        // reverse()
        sb.reverse();
        System.out.println("reverse(): " + sb);

        // capacity()
        int capacity = sb.capacity();
        System.out.println("capacity(): " + capacity);

        // ensureCapacity()
        sb.ensureCapacity(50);
        System.out.println("ensureCapacity(50): " + sb.capacity());

        // length()
        int length = sb.length();
        System.out.println("length(): " + length);

        // charAt()
        char charAt = sb.charAt(4);
        System.out.println("charAt(4): " + charAt);

        // substring()
        String subString = sb.substring(0, 5);
        System.out.println("substring(0, 5): " + subString);

        // setLength()
        sb.setLength(5);
        System.out.println("setLength(5): " + sb);

        // 2. StringBuilder Example
        System.out.println("\nStringBuilder Example:");
        StringBuilder sbuilder = new StringBuilder("Hello");

        // append()
        sbuilder.append(" World");
        System.out.println("append(): " + sbuilder);

        // insert()
        sbuilder.insert(5, ",");
        System.out.println("insert(): " + sbuilder);

        // replace()
        sbuilder.replace(6, 7, "-");
        System.out.println("replace(): " + sbuilder);

        // delete()
        sbuilder.delete(5, 6);
        System.out.println("delete(): " + sbuilder);

        // deleteCharAt()
        sbuilder.deleteCharAt(5);
        System.out.println("deleteCharAt(): " + sbuilder);

        // reverse()
        sbuilder.reverse();
        System.out.println("reverse(): " + sbuilder);

        // capacity()
        int sbCapacity = sbuilder.capacity();
        System.out.println("capacity(): " + sbCapacity);

        // ensureCapacity()
        sbuilder.ensureCapacity(50);
        System.out.println("ensureCapacity(50): " + sbuilder.capacity());

        // length()
        int sbLength = sbuilder.length();
        System.out.println("length(): " + sbLength);

        // charAt()
        char sbCharAt = sbuilder.charAt(4);
        System.out.println("charAt(4): " + sbCharAt);

        // substring()
        String sbSubString = sbuilder.substring(0, 5);
        System.out.println("substring(0, 5): " + sbSubString);

        // setLength()
        sbuilder.setLength(5);
        System.out.println("setLength(5): " + sbuilder);
    }
}

