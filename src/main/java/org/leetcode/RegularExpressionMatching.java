package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/regular-expression-matching/description/
10. Regular Expression Matching
Hard
Topics
Companies
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
* */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
    }//main

    private Map<String, Boolean> memo;
    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return match(s, p, 0, 0);
    }//isMatch

    //with memoziation
    private boolean match(String s, String p, int i, int j) {
        String key = i + "," + j;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (i >= s.length() && j >= p.length()) {
            memo.put(key, true);
            return true;
        }

        if (j >= p.length()) {
            memo.put(key, false);
            return false;
        }

        boolean matched = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        //star case
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            boolean result = (match(s, p, i, j + 2) || (matched && match(s, p, i + 1, j)));
            memo.put(key, result);
            return result;
        }

        if (matched) {
            boolean result = match(s, p, i + 1, j + 1);
            memo.put(key, result);
            return result;
        }
        memo.put(key, false);
        return false;
    }//match
/*
//    brute force approach
    private boolean match(String s, String p, int i, int j) {

        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        if (j >= p.length()) {
            return false;
        }

        boolean matched = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        //star case
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            return (match(s, p, i, j + 2) || (matched && match(s, p, i + 1, j)));
        }

        if (matched) {
            return match(s, p, i + 1, j + 1);
        }

        return false;


    }//match*/
    
    /*public boolean isMatch(String s, String p) {

        int sPointer =0;
        int pPointer =0;

        int sLen =s.length();
        int pLen = p.length();

        //for * case
        if (p.contains("*")) {

            int starPos = p.indexOf('*');

            while (starPos < pLen && starPos != -1) {
                pPointer= starPos;
                char preceedingElement = p.charAt(starPos - 1);
                if (preceedingElement == '.') {
                    return true;
                }
                if (preceedingElement != '.' ) {
                  while(sPointer < sLen && s.charAt(sPointer) == preceedingElement ){
                      sPointer++;
                  }
                }
                starPos= p.indexOf('*',starPos+1);
            }
        }

        //for . case
        if (p.contains(".")) {
            return s.length() == 1;
        }

        if(pPointer != (pLen-1)){
            return s.charAt(sPointer) == p.charAt(pPointer);
        }
        return s.contentEquals(p);
    }//isMatch*/
}//RegularExpressionMatching
