package org.leetcode;

import java.util.Stack;

/*https://leetcode.com/problems/valid-parentheses/description/
20. Valid Parentheses
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
* */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid(")(){}"));
    }

    public boolean isValid(String s) {

        Stack stack = new Stack();
        char[] charArray = s.toCharArray();
        if (charArray.length <= 1) {
            return false;
        }
        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (!stack.isEmpty()) {
                if (ch == ')' && '(' != (char) stack.pop()) {
                    return false;
                } else if (ch == '}' && '{' != (char) stack.pop()) {
                    return false;
                } else if (ch == ']' && '[' != (char) stack.pop()) {
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.empty();
    }
}
