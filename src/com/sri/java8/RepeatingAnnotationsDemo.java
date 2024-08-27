package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Demonstrates the usage of Repeating Annotations in Java.
 *
 * Repeating annotations allow the same annotation to be applied multiple times to the same element.
 * This was introduced in Java 8 to avoid the need for creating container annotations.
 */
public class RepeatingAnnotationsDemo {

    public static void main(String[] args) {
        Class<ExampleClass> clazz = ExampleClass.class;
        Schedules schedules = clazz.getAnnotation(Schedules.class);

        for (Schedule schedule : schedules.value()) {
            System.out.println("Schedule: " + schedule.day());
        }
    }
}

@Repeatable(Schedules.class)
@interface Schedule {
    String day();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Schedules {
    Schedule[] value();
}

@Schedule(day = "Monday")
@Schedule(day = "Wednesday")
@Schedule(day = "Friday")
class ExampleClass {
}

