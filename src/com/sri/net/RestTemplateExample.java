// package com.sri.net;

// /**
//  * Copyright (c) 2024 Srikanth Pula. All rights reserved.
//  *
//  * @author Srikanth Pula
//  * Date: 26-08-2024
//  */

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;

// /**
//  * Demonstrates making HTTP calls using RestTemplate in Spring Framework.
//  */
// public class RestTemplateExample {

//     public static void main(String[] args) {
//         RestTemplate restTemplate = new RestTemplate();

//         // GET request
//         String getUrl = "https://jsonplaceholder.typicode.com/posts/1";
//         ResponseEntity<String> getResponse = restTemplate.getForEntity(getUrl, String.class);
//         System.out.println("GET Response: " + getResponse.getBody());

//         // POST request
//         String postUrl = "https://jsonplaceholder.typicode.com/posts";
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);

//         String jsonRequest = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
//         HttpEntity<String> request = new HttpEntity<>(jsonRequest, headers);

//         ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, request, String.class);
//         System.out.println("POST Response: " + postResponse.getBody());
//     }
// }

