package com.sri.net;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

/**
 * Demonstrates making HTTP calls using HttpClient in Java 11+.
 */
public class HttpClientExample {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // GET request
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                    .GET()
                    .build();

            HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
            System.out.println("GET Response: " + getResponse.body());

            // POST request
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}"))
                    .build();

            HttpResponse<String> postResponse = client.send(postRequest, BodyHandlers.ofString());
            System.out.println("POST Response: " + postResponse.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

