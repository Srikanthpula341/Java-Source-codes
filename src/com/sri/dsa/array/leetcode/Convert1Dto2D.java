package com.sri.dsa.array.leetcode;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 01-09-2024
 */

public class Convert1Dto2D {
    public static void main(String[] args) {
        int[] original1 = {1, 2, 3, 4};
        int m1 = 2;
        int n1 = 2;
        int[][] result1 = construct2DArray(original1, m1, n1);
        System.out.println("Example 1 Output:");
        print2DArray(result1);

        int[] original2 = {1, 2, 3};
        int m2 = 1;
        int n2 = 3;
        int[][] result2 = construct2DArray(original2, m2, n2);
        System.out.println("Example 2 Output:");
        print2DArray(result2);

        int[] original3 = {1, 2};
        int m3 = 1;
        int n3 = 1;
        int[][] result3 = construct2DArray(original3, m3, n3);
        System.out.println("Example 3 Output:");
        print2DArray(result3);
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {

        if(m*n != original.length){
            return new int[0][0];
        }

        int [][] arr = new int [m][n];

        for(int i=0;i<original.length;i++){
            int col = i%n;
            int row = i/n;
            arr[row][col]= original[i];
        }



        return arr;
    }

    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
