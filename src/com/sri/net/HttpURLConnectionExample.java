package com.sri.net;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Demonstrates making HTTP calls using HttpURLConnection in Java.
 * 
 * This class showcases how to perform GET, POST, PUT, and DELETE requests using the 
 * HttpURLConnection class in Java. HttpURLConnection is a low-level API for interacting
 * with HTTP servers. It is part of the java.net package and has been available since Java 1.1.
 */
public class HttpURLConnectionExample {

    /**
     * Main method to demonstrate HTTP requests using HttpURLConnection.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Perform a GET request
            performGetRequest();

            // Perform a POST request
            performPostRequest();

            // Perform a PUT request
            performPutRequest();

            // Perform a DELETE request
            performDeleteRequest();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a GET request to retrieve data from the server.
     * 
     * A GET request is used to retrieve information from the server at the specified URL.
     * The response is then read line by line and stored in a StringBuffer to be printed.
     *
     * @throws Exception if an I/O error occurs.
     */
    private static void performGetRequest() throws Exception {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");  // Set the HTTP method to GET

        int responseCode = conn.getResponseCode();  // Get the response code (e.g., 200 for OK)

        if (responseCode == HttpURLConnection.HTTP_OK) {  // Check if the response code indicates success
            // Create a BufferedReader to read the input stream from the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String inputLine;
            StringBuffer response = new StringBuffer();  // Use StringBuffer to build the complete response string

            // Read each line from the input stream and append it to the response buffer
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();  // Close the BufferedReader when done
            conn.disconnect(); 

            // Print the response string
            System.out.println("GET Response: " + response.toString());
        } else {
            System.out.println("GET request failed");
        }

    }

    /**
     * Performs a POST request by sending JSON data to the server.
     * 
     * A POST request is used to send data to the server to create a new resource. The JSON data
     * is sent in the request body, and the server's response is read and printed.
     *
     * @throws Exception if an I/O error occurs.
     */
    private static void performPostRequest() throws Exception {
        URL postUrl = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection postConn = (HttpURLConnection) postUrl.openConnection();
        postConn.setRequestMethod("POST");  // Set the HTTP method to POST
        postConn.setRequestProperty("Content-Type", "application/json; utf-8");  // Set the request content type to JSON
        postConn.setDoOutput(true);  // Allow sending data to the server
        

        String jsonInputString = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

        // Write the JSON data to the output stream of the connection
        try (OutputStream os = postConn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Create a BufferedReader to read the response from the server
        BufferedReader postIn = new BufferedReader(new InputStreamReader(postConn.getInputStream(), "utf-8"));
        StringBuilder postResponse = new StringBuilder();  // Use StringBuilder to build the complete response string
        String postInputLine;

        // Read each line from the input stream and append it to the response string
        while ((postInputLine = postIn.readLine()) != null) {
            postResponse.append(postInputLine.trim());
        }
        postIn.close();  // Close the BufferedReader when done
        postConn.disconnect();

        // Print the response string
        System.out.println("POST Response: " + postResponse.toString());
    }

    /**
     * Performs a PUT request by sending updated JSON data to the server.
     * 
     * A PUT request is used to update an existing resource on the server. The JSON data
     * is sent in the request body, and the server's response is read and printed.
     *
     * @throws Exception if an I/O error occurs.
     */
    private static void performPutRequest() throws Exception {
        URL putUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection putConn = (HttpURLConnection) putUrl.openConnection();
        putConn.setRequestMethod("PUT");  // Set the HTTP method to PUT
        putConn.setRequestProperty("Content-Type", "application/json; utf-8");  // Set the request content type to JSON
        putConn.setDoOutput(true);  // Allow sending data to the server

        String jsonInputString = "{\"id\":1,\"title\":\"updated title\",\"body\":\"updated body\",\"userId\":1}";

        // Write the JSON data to the output stream of the connection
        try (OutputStream os = putConn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Create a BufferedReader to read the response from the server
        BufferedReader putIn = new BufferedReader(new InputStreamReader(putConn.getInputStream(), "utf-8"));
        StringBuilder putResponse = new StringBuilder();  // Use StringBuilder to build the complete response string
        String putInputLine;

        // Read each line from the input stream and append it to the response string
        while ((putInputLine = putIn.readLine()) != null) {
            putResponse.append(putInputLine.trim());
        }
        putIn.close();  // Close the BufferedReader when done
        putConn.disconnect();

        // Print the response string
        System.out.println("PUT Response: " + putResponse.toString());
    }

    /**
     * Performs a DELETE request to remove data from the server.
     * 
     * A DELETE request is used to remove a resource from the server. The response code
     * is checked to determine if the request was successful.
     *
     * @throws Exception if an I/O error occurs.
     */
    private static void performDeleteRequest() throws Exception {
        URL deleteUrl = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection deleteConn = (HttpURLConnection) deleteUrl.openConnection();
        deleteConn.setRequestMethod("DELETE");  // Set the HTTP method to DELETE
        int responseCode = deleteConn.getResponseCode();  // Get the response code

        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
            System.out.println("DELETE request successful");
        } else {
            System.out.println("DELETE request failed");
        }
    }
}
