package org.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*https://leetcode.com/problems/longest-palindromic-substring/
*
* 5. Longest Palindromic Substring
Medium
Topics
Companies
Hint
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
* */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        List<String> list = new ArrayList<>();
        list = combinations("", s, list);
        return list.stream().filter(str -> isPalindrome(str)).max(Comparator.comparing(String::length)).get();
    }

    public List<String> combinations(String p, String up, List list) {
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        //take character
        up = up.substring(1);
        combinations(p + ch, up, list);
        //ignore character
        combinations(p, up, list);
        return list;
    }

    private boolean isPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }
}//LongestPalindromicCombination
