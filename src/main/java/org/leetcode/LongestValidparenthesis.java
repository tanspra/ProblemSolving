package org.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidparenthesis {
    public static void main(String[] args) {
        System.out.println(new LongestValidparenthesis().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maxLength = Math.max(maxLength, i - stack.peek());
            }
        }
        return maxLength;
    }
}
