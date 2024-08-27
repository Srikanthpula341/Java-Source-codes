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
 * 
 * The HttpClient class in Java 11 provides a modern and flexible way to perform HTTP requests.
 * This class includes examples of GET, POST, PUT, DELETE, HEAD, OPTIONS, and PATCH methods.
 */
public class HttpClientExample {

    /**
     * Main method to demonstrate various HTTP methods using HttpClient.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Create an HttpClient with a 10-second timeout
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // Perform a GET request
            performGetRequest(client);

            // Perform a POST request
            performPostRequest(client);

            // Perform a PUT request
            performPutRequest(client);

            // Perform a DELETE request
            performDeleteRequest(client);

            // Perform a HEAD request
            performHeadRequest(client);

            // Perform an OPTIONS request
            performOptionsRequest(client);

            // Perform a PATCH request
            performPatchRequest(client);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a GET request to retrieve data from the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performGetRequest(HttpClient client) throws Exception {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/2"))
                .GET()
                .build();

        HttpResponse<String> getResponse = client.send(getRequest, BodyHandlers.ofString());
        System.out.println("GET Response: " + getResponse.body());
    }

    /**
     * Performs a POST request to send JSON data to the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performPostRequest(HttpClient client) throws Exception {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}"))
                .build();

        HttpResponse<String> postResponse = client.send(postRequest, BodyHandlers.ofString());
        System.out.println("POST Response: " + postResponse.body());
    }

    /**
     * Performs a PUT request to update existing data on the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performPutRequest(HttpClient client) throws Exception {
        HttpRequest putRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/2"))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString("{\"id\":2,\"title\":\"updated title\",\"body\":\"updated body\",\"userId\":1}"))
                .build();

        HttpResponse<String> putResponse = client.send(putRequest, BodyHandlers.ofString());
        System.out.println("PUT Response: " + putResponse.body());
    }

    /**
     * Performs a DELETE request to remove data from the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performDeleteRequest(HttpClient client) throws Exception {
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/2"))
                .DELETE()
                .build();

        HttpResponse<String> deleteResponse = client.send(deleteRequest, BodyHandlers.ofString());
        System.out.println("DELETE Response: " + deleteResponse.body());
    }

    /**
     * Performs a HEAD request to retrieve headers from the server without the body.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performHeadRequest(HttpClient client) throws Exception {
        HttpRequest headRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/2"))
                .method("HEAD", BodyPublishers.noBody())
                .build();

        HttpResponse<Void> headResponse = client.send(headRequest, BodyHandlers.discarding());
        System.out.println("HEAD Response Code: " + headResponse.statusCode());
        headResponse.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * Performs an OPTIONS request to retrieve the supported HTTP methods from the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performOptionsRequest(HttpClient client) throws Exception {
        HttpRequest optionsRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .method("OPTIONS", BodyPublishers.noBody())
                .build();

        HttpResponse<Void> optionsResponse = client.send(optionsRequest, BodyHandlers.discarding());
        System.out.println("OPTIONS Response Code: " + optionsResponse.statusCode());
        optionsResponse.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * Performs a PATCH request to partially update a resource on the server.
     *
     * @param client The HttpClient instance to use for the request.
     * @throws Exception if an error occurs during the request.
     */
    private static void performPatchRequest(HttpClient client) throws Exception {
        HttpRequest patchRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/2"))
                .header("Content-Type", "application/json")
                .method("PATCH", BodyPublishers.ofString("{\"title\":\"partially updated title\"}"))
                .build();

        HttpResponse<String> patchResponse = client.send(patchRequest, BodyHandlers.ofString());
        System.out.println("PATCH Response: " + patchResponse.body());
    }
}
