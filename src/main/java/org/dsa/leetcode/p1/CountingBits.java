package org.dsa.leetcode.p1;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int[] ints = new CountingBits().countBits(2);
        System.out.println(Arrays.toString(ints));
    }
    public int[] countBits(int n) {
    int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

}
