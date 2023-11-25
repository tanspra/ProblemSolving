package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/*3. Longest Substring Without Repeating Characters
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
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
//        Set<Character> charSet = new HashSet<>();
//        int max=0,current=0;
//        for(Character ch : s.toCharArray()){
//            if(charSet.contains(ch)){
//               charSet=new HashSet<>();
//               if(current>max){
//                   max=current;
//               }
//               current=1;
//            }else{
//                charSet.add(ch);
//                current++;
//            }
//
//        }
//        return max>current?max:current;

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
