package com.sri.dsa.array.sdet;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 12-06-2024
 */


import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to remove all occurrences of a specified value from an integer array.
 * It iterates through the array, keeping track of the count of elements different from the specified value,
 * and rearranges the elements in place to remove the specified value.
 * <p>
 * Usage: This method can be used to remove all occurrences of a specified value from an integer array.
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(1) since the removal is done in place without needing additional space.
 */
public class RemoveSelectedElement {

    /**
     * Removes all occurrences of a specified value from an integer array in place.
     *
     * @param nums An array of integers from which occurrences of the specified value are to be removed.
     * @param val  The value to be removed from the array.
     * @return The number of elements in the modified array after removal of occurrences of the specified value.
     */
    public static int removeElement(int[] nums, int val) {
        int count = 0; // Counter to track elements different from the specified value

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to the specified value
            if (nums[i] != val) {
                // Move the current element to the position indicated by the count
                nums[count] = nums[i];
                // Increment the count to indicate the next position for a different element
                count++;
            }
        }

        // Return the count, which represents the number of elements in the modified array
        return count;
    }

    // Main method for testing the removeElement function
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        System.out.println("New Length: " + newLength);
        System.out.print("Modified Array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }


        for (int i = 0; i < strs.length; i++) {

            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }

        }


        return strs[0];
    }
    public int strStr(String haystack, String needle) {

        if(haystack==needle){
            return 0;
        }
        if(!haystack.contains(needle)){
            return -1;
        }


        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.substring(i,i+needle.length()).contains(needle)){
                return  i;
            }
        }

        return 0;
    }

    public int romanToInt(String s) {

        Map<Character, Integer> map= new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans=0;

        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);

            int val = map.get(ch);

            if(i<s.length()-1 && map.get(s.charAt(i+1))>val){
                ans-=val;
            }else{
                ans+=val;
            }
        }
        return 0;
    }

    public String mergeAlternately(String word1, String word2) {

        if(word1==null){
            return word2;
        }
        if(word2 ==null){
            return  word1;
        }

        return "";
    }
}





