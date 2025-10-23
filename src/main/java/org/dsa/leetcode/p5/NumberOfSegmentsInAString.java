package org.dsa.leetcode.p5;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s.length() ==0)
            return 0;
        String[] s1 = s.split(" ");
        return s1.length;
    }
}
