package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.util.Base64;

/**
 * Demonstrates the usage of Base64 Encoding and Decoding in Java.
 *
 * Java 8 introduced a new Base64 API that allows encoding and decoding operations for Base64 data.
 * It supports basic, URL, and MIME encoding/decoding.
 */
public class Base64EncodingDecodingDemo {

    public static void main(String[] args) {
        String originalString = "Hello, World!";

        // Encode using Basic encoding
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String (Basic): " + encodedString);

        // Decode using Basic decoding
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded String: " + decodedString);

        // Encode using URL encoding
        String urlEncodedString = Base64.getUrlEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String (URL): " + urlEncodedString);

        // Encode using MIME encoding
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String (MIME): " + mimeEncodedString);
    }
}

