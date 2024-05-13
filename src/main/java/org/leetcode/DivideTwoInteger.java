package org.leetcode;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoInteger {
    public static void main(String[] args) {
        System.out.println(new DivideTwoInteger().divide(-23,-17));
    }
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) return 2147483647;
        return dividend / divisor;
    }
}
