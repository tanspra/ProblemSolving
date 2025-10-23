package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        List<String> strings = new BinaryWatch().readBinaryWatch(1);
        System.out.println(strings.toString());
    }
    public List<String> readBinaryWatch(int turnedOn) {
    List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    res.add(formatToTime(i,j));
                }
            }
        }
    return res;
    }

    private String formatToTime(int i, int j) {
        StringBuilder sb = new StringBuilder(i+":");
        if(j<10){
            sb.append("0"+j);
        }else{
            sb.append(j);
        }
        return sb.toString();
    }
}
