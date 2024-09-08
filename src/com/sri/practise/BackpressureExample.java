package com.sri.practise;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class BackpressureExample {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .delayElements(Duration.ofMillis(500)) // Delay each element by 0.5 seconds
                .log()
                .onBackpressureBuffer(1000) // Buffer size to accommodate all items
                .publishOn(Schedulers.parallel())
                .doOnNext(item -> System.out.println("Processed: " + item))
                .blockLast(); // Block until the last item is processed
    }
}
