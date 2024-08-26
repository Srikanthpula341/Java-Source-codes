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
 */
public class HttpURLConnectionExample {

    public static void main(String[] args) {
        try {
            // GET request
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print result
                System.out.println("GET Response: " + response.toString());
            } else {
                System.out.println("GET request failed");
            }

            // POST request
            URL postUrl = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection postConn = (HttpURLConnection) postUrl.openConnection();
            postConn.setRequestMethod("POST");
            postConn.setRequestProperty("Content-Type", "application/json; utf-8");
            postConn.setDoOutput(true);

            String jsonInputString = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

            try (OutputStream os = postConn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader postIn = new BufferedReader(new InputStreamReader(postConn.getInputStream(), "utf-8"));
            StringBuilder postResponse = new StringBuilder();
            String postInputLine;
            while ((postInputLine = postIn.readLine()) != null) {
                postResponse.append(postInputLine.trim());
            }
            postIn.close();

            System.out.println("POST Response: " + postResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

