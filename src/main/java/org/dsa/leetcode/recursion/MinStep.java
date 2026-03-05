package org.dsa.leetcode.recursion;

import java.util.Arrays;

public class MinStep {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(minSteps(num));
        System.out.println(minSteps2(num));
    }

    public static int minSteps2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 0;
        return minStepHelper(n, memo);
    }

    private static int minStepHelper(int n, int[] memo) {
        if (memo[n] != -1) return memo[n];
        int res = minStepHelper(n - 1, memo);
        if (n % 2 == 0)
            res = Math.min(res, minStepHelper(n / 2, memo));
        if (n % 3 == 0)
            res = Math.min(res, minStepHelper(n / 3, memo));
        memo[n] = 1+ res;
        return memo[n];
    }

    public static int minSteps(int n) {
        if (n <= 1) return 0;
        int x = minSteps(n - 1);
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;
        if (n % 2 == 0)
            y = minSteps(n / 2);
        if (n % 3 == 0)
            z = minSteps(n / 3);
        return Math.min(x, Math.min(y, z)) + 1;
    }
}
