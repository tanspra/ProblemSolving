package org.dsa.leetcode.p2;

/*https://leetcode.com/problems/longest-common-prefix/description/
14. Longest Common Prefix
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
* */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }//main

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        boolean ansFound = false;
        String shortestString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestString.length()) {
                shortestString = strs[i];
            }
        }
        for (int i = 0; i < shortestString.length(); i++) {
            char ch = shortestString.charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    ansFound = true;
                    break;
                }
            }
            if (!ansFound) {
                res.append(ch);
            }
            if (ansFound) {
                break;
            }
        }
        return res.toString();
    }//longestCommonPrefix
}//main
/* LeetCode min ms answer
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0){
            return "";

        }
        String prefix = strs[0];
        for(int i=0;i<strs.length;i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;



    }
}
* */