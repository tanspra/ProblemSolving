package org.dsa.leetcode.p1;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
  }
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
        res.append(String.valueOf(ch));
      }
      if (ansFound) {
        break;
      }
    }
    return res.toString();
  }//longestCommonPrefix
}
