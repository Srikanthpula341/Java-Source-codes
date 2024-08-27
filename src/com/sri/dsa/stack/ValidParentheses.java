package com.sri.dsa.stack;

import java.util.Stack;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 14-06-2024
 */

public class ValidParentheses {

    public boolean isValid(String s) {

        if(s.length()%2!=0) return false;


        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch= s.charAt(i);
            if(ch =='(' || ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(ch==')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(ch=='}' && stack.peek()=='{'){
                    stack.pop();
                }
                else if(ch==']' && stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }

    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;

        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!=null && fast!=null){
            if(slow==fast){
                return true;
            }else{
                slow=slow.next;
                fast=fast.next.next;
            }
        }


        return  false;
    }


}
