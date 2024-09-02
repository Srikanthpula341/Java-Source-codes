package com.sri.practise;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BackpressureExample {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .onBackpressureBuffer(10) // Buffering with a max size of 10
                .publishOn(Schedulers.parallel())
                .subscribe(
                        item -> {
                            try {
                                Thread.sleep(100); // Simulate slow processing
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                            System.out.println("Processed: " + item);
                        },
                        err -> System.err.println("Error: " + err),
                        () -> System.out.println("Done"));
    }
}
