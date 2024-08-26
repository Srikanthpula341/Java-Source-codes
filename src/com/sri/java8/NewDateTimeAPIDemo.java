package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates the usage of the new Date and Time API (java.time package) introduced in Java 8.
 *
 * The new Date and Time API provides a more comprehensive and flexible way to handle dates and times.
 * It includes classes like LocalDate, LocalTime, LocalDateTime, ZonedDateTime, and many others.
 * These classes are immutable and thread-safe.
 */
public class NewDateTimeAPIDemo {

    public static void main(String[] args) {
        // 1. LocalDate Example
        /**
         * LocalDate represents a date (year, month, day) without time or time zone information.
         * It can be used to represent dates like birthdays, anniversaries, etc.
         */
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        LocalDate specificDate = LocalDate.of(2020, Month.JANUARY, 1);
        System.out.println("Specific Date: " + specificDate);

        // 2. LocalTime Example
        /**
         * LocalTime represents a time (hour, minute, second, nanosecond) without date or time zone information.
         * It can be used to represent times like office hours, meeting times, etc.
         */
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime specificTime = LocalTime.of(14, 30, 0);
        System.out.println("Specific Time: " + specificTime);

        // 3. LocalDateTime Example
        /**
         * LocalDateTime represents a combination of date and time without time zone information.
         * It can be used to represent a specific moment in time.
         */
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(2020, Month.JANUARY, 1, 10, 30);
        System.out.println("Specific Date and Time: " + specificDateTime);

        // 4. ZonedDateTime Example
        /**
         * ZonedDateTime represents a date and time with a time zone.
         * It can be used to represent a specific moment in time with respect to a time zone.
         */
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time with Time Zone: " + currentZonedDateTime);

        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(specificDateTime, ZoneId.of("America/New_York"));
        System.out.println("Specific Date and Time with Time Zone: " + specificZonedDateTime);

        // 5. DateTimeFormatter Example
        /**
         * DateTimeFormatter is used to format and parse dates and times.
         * It provides a way to format dates and times into strings and parse strings into dates and times.
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted Current Date and Time: " + formattedDateTime);

        LocalDateTime parsedDateTime = LocalDateTime.parse("01/01/2020 10:30:00", formatter);
        System.out.println("Parsed Date and Time: " + parsedDateTime);

        // 6. Period and Duration Example
        /**
         * Period is used to represent a quantity of time in terms of years, months, and days.
         * Duration is used to represent a quantity of time in terms of seconds and nanoseconds.
         */
        LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2021, Month.JANUARY, 1);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between " + date1 + " and " + date2 + ": " + daysBetween);

        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(12, 0);
        long minutesBetween = ChronoUnit.MINUTES.between(time1, time2);
        System.out.println("Minutes between " + time1 + " and " + time2 + ": " + minutesBetween);
    }
}

