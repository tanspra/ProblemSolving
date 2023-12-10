package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/longest-substring-without-repeating-characters/
3. Longest Substring Without Repeating Characters
Attempted
Medium
Topics
Companies
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
//        String str = "pwwkew";
        String str = "ohvhjdml";
        System.out.println(new LongestSubStringWithoutRepeatingCharacter()
                .lengthOfLongestSubstringUsingRecursion(str));
    }

    public int lengthOfLongestSubstringUsingRecursion(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        return findMaxLengthSubstring("", s, 0);

    }

    private int findMaxLengthSubstring(String p, String up, int maxLength) {
        if (up.length() == 0) {
            return Math.max(maxLength, p.length());
        }

        //current character
        char currentChar = up.charAt(0);
        int indexOfChar = p.indexOf(currentChar);

        if (indexOfChar == -1) {
            p = p + currentChar;
            return findMaxLengthSubstring(p, up.substring(1), Math.max(maxLength, p.length()));
        } else {
            if (indexOfChar == 0) {
                p = p.substring(1) + currentChar;
            } else if (indexOfChar == p.length() - 1) {
                p = "" + currentChar;
            } else {
                p = p.substring(indexOfChar + 1) + currentChar;
            }
            return findMaxLengthSubstring(p, up.substring(1), Math.max(maxLength, p.length()));
        }

    }

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
