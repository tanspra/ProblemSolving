package org.dsa.leetcode.p1;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            int value = c - 'A' + 1;   // Convert 'A' → 1, 'B' → 2, ... 'Z' → 26
            result = result * 26 + value;
        }
        return result;
    }
}
