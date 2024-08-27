// package com.sri.net;

// /**
//  * Copyright (c) 2024 Srikanth Pula. All rights reserved.
//  *
//  * @author Srikanth Pula
//  * Date: 26-08-2024
//  */

// import okhttp3.*;

// import java.io.IOException;

// /**
//  * Demonstrates making HTTP calls using OkHttpClient in Java.
//  */
// public class OkHttpClientExample {

//     public static void main(String[] args) {
//         OkHttpClient client = new OkHttpClient();

//         // GET request
//         Request getRequest = new Request.Builder()
//                 .url("https://jsonplaceholder.typicode.com/posts/1")
//                 .build();

//         try (Response getResponse = client.newCall(getRequest).execute()) {
//             if (getResponse.isSuccessful()) {
//                 System.out.println("GET Response: " + getResponse.body().string());
//             } else {
//                 System.out.println("GET request failed");
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // POST request
//         MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//         RequestBody postBody = RequestBody.create(JSON, "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}");

//         Request postRequest = new Request.Builder()
//                 .url("https://jsonplaceholder.typicode.com/posts")
//                 .post(postBody)
//                 .build();

//         try (Response postResponse = client.newCall(postRequest).execute()) {
//             if (postResponse.isSuccessful()) {
//                 System.out.println("POST Response: " + postResponse.body().string());
//             } else {
//                 System.out.println("POST request failed");
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

