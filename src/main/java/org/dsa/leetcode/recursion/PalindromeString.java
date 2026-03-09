package org.dsa.leetcode.recursion;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(new PalindromeString().isPalindrome("abba"));
    }

    boolean isPalindrome(String s) {
        // code here
        return palindromeHelper(s, 0, s.length()-1);
    }
    boolean palindromeHelper(String s, int low, int high){
        int length = high - low + 1;
        if(length == 0 || length ==1) return true;
        if(s.charAt(low) != s.charAt(high))
            return false;
        return palindromeHelper(s, low+1, high-1);
    }
}
