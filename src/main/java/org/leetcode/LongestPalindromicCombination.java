package org.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromicCombination {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicCombination()
                .longestPalindrome("aacabdkacaa"));
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
