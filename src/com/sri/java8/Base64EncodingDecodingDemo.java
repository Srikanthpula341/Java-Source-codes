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
 * Base64 is a binary-to-text encoding scheme that represents binary data in an
 * ASCII string format.
 * It is commonly used for encoding data that needs to be stored and transferred
 * over media that are
 * designed to deal with textual data. This includes encoding binary data like
 * images, audio files,
 * or any other media that needs to be sent over network protocols like HTTP,
 * SMTP, etc.
 * 
 * Java 8 introduced a new Base64 API that allows encoding and decoding
 * operations for Base64 data.
 * The API supports three different variants of Base64 encoding and decoding:
 * 
 * 1. **Basic Encoding/Decoding**:
 * - Encodes data without any line separation.
 * - It is the standard Base64 encoding.
 *
 * 2. **URL Encoding/Decoding**:
 * - This variant is used when the encoded data needs to be safely included in
 * URLs or file names.
 * - It replaces '+' with '-' and '/' with '_'.
 *
 * 3. **MIME Encoding/Decoding**:
 * - This variant is used when encoding data that needs to be MIME (Multipurpose
 * Internet Mail Extensions) compliant.
 * - It inserts line breaks after every 76 characters to make the data more
 * readable and to conform to MIME specifications.
 */
public class Base64EncodingDecodingDemo {

    /**
     * Main method to demonstrate Base64 encoding and decoding in different modes.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String originalString = "Hello, World!_+/";

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

        // Decode using URL decoding
        byte[] urlDecodedBytes = Base64.getUrlDecoder().decode(urlEncodedString);
        String urlDecodedString = new String(urlDecodedBytes);
        System.out.println("Decoded String (URL): " + urlDecodedString);

        // Encode using MIME encoding
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String (MIME): " + mimeEncodedString);

        // Decode using MIME decoding
        byte[] mimeDecodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
        String mimeDecodedString = new String(mimeDecodedBytes);
        System.out.println("Decoded String (MIME): " + mimeDecodedString);
    }
}
