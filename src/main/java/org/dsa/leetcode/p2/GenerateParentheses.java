package org.dsa.leetcode.p2;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/generate-parentheses/description/
22. Generate Parentheses
Medium
Topics
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
* */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(4).toString());
    }
    public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    backtrack(list, 0, 0, "", n);
    return list;
    }
    public void backtrack(List res, int open, int close,String str, int n){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(open < n){
            backtrack(res, open+1 , close, str + "(", n);
        }
        if(close < open){
            backtrack(res, open , close+1, str + ")", n);
        }
    }
}
