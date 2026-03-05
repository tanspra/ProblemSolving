package org.dsa.leetcode.p4;

import java.util.Stack;

//https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{}));
    }
    public int singleNumber(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }else{
                if(stack.peek() == nums[i]){
                    stack.pop();
                }
            }
        }
    return stack.pop();
    }
}
