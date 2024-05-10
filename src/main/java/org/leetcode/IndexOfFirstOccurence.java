package org.leetcode;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

public class IndexOfFirstOccurence {
    public static void main(String[] args) {
        System.out.println(new IndexOfFirstOccurence().strStr("sadbutsad","sada"));
    }

    public int strStr(String haystack, String needle) {
        StringBuilder stringBuilder = new StringBuilder(haystack);
        return stringBuilder.indexOf(needle);
    }
}
