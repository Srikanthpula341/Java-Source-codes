package com.sri.dsa.array.leetcode;

import java.util.stream.IntStream;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 01-09-2024
 */

public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = s.charAt(0)=='-';
        int startIndex = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;

        int result = IntStream.range(startIndex, s.length())
                .map(s::charAt)
                .filter(Character::isDigit)
                .map(c->c -'0')
                .reduce(0, (acc, digit) -> acc * 10 + digit);
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {

        StringToInteger si = new StringToInteger();
        System.out.println(si.myAtoi("42"));
    }
}
