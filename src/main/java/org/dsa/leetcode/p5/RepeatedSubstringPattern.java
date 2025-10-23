package org.dsa.leetcode.p5;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern2("abab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int strLength = s.length();
        for (int i = 1; i <= strLength; i++) {
            String subString = s.substring(0,i);
            int subStringlength = subString.length();
            if(strLength % subStringlength ==0){
                int times = strLength/subStringlength;
                if(s.equalsIgnoreCase(subString.repeat(times)) && times > 1)
                    return true;
            }
        }
    return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
