package com.sri.dsa.array.sdet;

import java.util.Scanner;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 11-06-2024
 */

public class TrappingRainWater {
    // Function to get the histogram heights from the user
    public static int[] getHistogramHeights() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the heights of the histogram bars separated by spaces:");

        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        int[] heights = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            heights[i] = Integer.parseInt(inputArray[i]);
        }

        return heights;
    }

    // Function to solve the Trapping Rain Water problem
    public static int trap(int[] height) {
        // TODO: Add your logic here
        int ans = 0;


        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j > -1; j--) {
                if (height[j] >= leftMax) {
                    leftMax = height[j];
                }
            }

            for (int k = i; k < height.length; k++) {
                if (height[k] >= rightMax) {
                    rightMax = height[k];
                }
            }
            if (Math.min(rightMax, leftMax) - height[i] > 0) {
                ans = ans + Math.min(rightMax, leftMax) - height[i];
            }


        }
        return ans; // Placeholder return value
    }

    // Main method to run the program
    public static void main(String[] args) {
        int[] histogramHeights = getHistogramHeights();

        int result = trap(histogramHeights);
        int result2 = trapOptimized(histogramHeights);
        System.out.println("Amount of trapped water: " + result + " " + result2);
    }

    private static int trapOptimized(int[] heights) {

        if (heights != null && heights.length != 0) {
            return 0;
        }
        int ans = 0;
        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = heights[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        rightMax[n - 1] = heights[n - 1];
        for (int j = n - 2; j > 0; j--) {
            rightMax[j - 1] = Math.max(rightMax[j + 1], heights[j]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - heights[i];

        }


        return ans;
    }

    private static int trapTwoPointer(int [] heights){

        if(heights==null || heights.length==0 ){
            return 0;
        }

        int ans=0;

        


        return ans;
    }
}
