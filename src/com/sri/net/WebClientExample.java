package com.sri.net;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Demonstrates making HTTP calls using WebClient in Spring WebFlux.
 */
public class WebClientExample {

    public static void main(String[] args) {
        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

        // GET request
        Mono<String> getResponse = client.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class);

        getResponse.subscribe(response -> System.out.println("GET Response: " + response));

        // POST request
        Mono<String> postResponse = client.post()
                .uri("/posts")
                .bodyValue("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}")
                .retrieve()
                .bodyToMono(String.class);

        postResponse.subscribe(response -> System.out.println("POST Response: " + response));
    }
}

