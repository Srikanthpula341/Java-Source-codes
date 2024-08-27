package com.sri.dsa.array.sdet;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 13-06-2024
 */

public class BullAndSell {

    public int maxProfit(int[] prices) {


        int ans=0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice=prices[i]; 
            } else if (ans<prices[i]-minPrice) {
                ans=prices[i]-minPrice;
                
            }
        }



        return ans;

    }

    public List<String> summaryRanges(int[] nums) {

        String str="";
        List<String> strList = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            str=str+nums[i];
           // if()

        }

        return null;
    }
}
