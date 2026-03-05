package org.dsa.leetcode.p2;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("A"));
    }
    public int longestPalindrome(String s) {
        int[] countArray = new int[59];
        boolean odd = false;
        int longestPalindrome = 0;
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'A'] ++;
        }
        for(int count : countArray){
            if((count & 1) == 1 && !odd){
                longestPalindrome = longestPalindrome + count;
                odd = true;
            }else{
                if(((count & 1) == 1))
                    longestPalindrome += count-1;
                else
                    longestPalindrome += count;
            }
        }
        return longestPalindrome;
    }
}
