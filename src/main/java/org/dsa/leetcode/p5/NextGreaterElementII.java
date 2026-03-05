package org.dsa.leetcode.p5;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(new int[]{1,2,1})));
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-2; i >= 0 ; i--) {
            stack.push(nums[i]);
        }
        for (int i = n-1; i >= 0 ; i--) {
           while(!stack.isEmpty() && stack.peek()<= nums[i])
               stack.pop();
           res[i] = stack.isEmpty() ? -1 : stack.peek();
           stack.push(nums[i]);
        }
        return res;
    }
}
