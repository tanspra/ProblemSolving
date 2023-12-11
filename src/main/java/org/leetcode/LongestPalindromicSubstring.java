//package org.leetcode;
//
///*https://leetcode.com/problems/longest-palindromic-substring/
//*
//* 5. Longest Palindromic Substring
//Medium
//Topics
//Companies
//Hint
//Given a string s, return the longest
//palindromic
//
//substring
// in s.
//
//
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consist of only digits and English letters.
//* */
//public class LongestPalindromeSubstring {
//    public static void main(String[] args) {
//   //     System.out.println(new LongestPalindromeSubstring().longestPalindrome("babad"));
//    }
//
//    public String longestPalindrome(String s) {
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//        if (s.length() == 1) {
//            return s;
//        }
//        return findMaxLengthPalindromeSubstring("", s, "");
//
//    }
//
//    private String findMaxLengthPalindromeSubstring(String p, String up, String ps) {
//
//        //base condition
//        if (up.isEmpty()) {
//            return (isPalindrome(p) && p.length() > ps.length()) ? p : ps;
//        }
//
//        //current character
//        char currentChar = up.charAt(0);
//     //   int indexOfChar = p.indexOf(currentChar);
//
//        //taking current char
//        p = p + currentChar;
//        //ignoring current char
//        if (indexOfChar == -1) {
//            p = p + currentChar;
//            return findMaxLengthPalindromeSubstring(p, up.substring(1), Math.max(maxLength, p.length()));
//        } else {
//            if (indexOfChar == 0) {
//                p = p.substring(1) + currentChar;
//            } else if (indexOfChar == p.length() - 1) {
//                p = "" + currentChar;
//            } else {
//                p = p.substring(indexOfChar + 1) + currentChar;
//            }
//            return findMaxLengthPalindromeSubstring(p, up.substring(1), Math.max(maxLength, p.length()));
//        }
//
//    }
//
//    private boolean isPalindrome(String str) {
//        return str.contentEquals(new StringBuilder(str).reverse());
//    }
//}
