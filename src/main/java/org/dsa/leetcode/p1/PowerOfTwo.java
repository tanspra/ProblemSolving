package org.dsa.leetcode.p1;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n >Integer.MAX_VALUE || n < Integer.MIN_VALUE)
            return false;
        else
            return (n & n - 1) == 0;
    }
}
