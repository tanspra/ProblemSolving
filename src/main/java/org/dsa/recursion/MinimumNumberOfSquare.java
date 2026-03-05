package org.dsa.recursion;

import java.util.Arrays;

public class MinimumNumberOfSquare {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(minimumSquare(num));
        System.out.println(minimumSquare2(num));
        System.out.println(minimumSquare3(num));
    }

    private static int minimumSquare3(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
    private static int minimumSquare2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        for (int i = 0; i < 4; i++) {
            memo[i] = i;
        }
        return minimumSquareHelper(n, memo);
    }

    private static int minimumSquareHelper(int n, int[] memo) {
        if (Math.sqrt(n) % n == 0) {
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int res = 1 + minimumSquare(n - 1);
        for (int i = 2; i < Math.sqrt(n); i++) {
            res = Math.min(res, minimumSquare(n - i * i));
        }
        memo[n] = res;
        return memo[n];
    }

    private static int minimumSquare(int n) {
        if (Math.sqrt(n) % n == 0) {
            return 1;
        }
        int res = 1 + minimumSquare(n - 1);
        for (int i = 2; i < Math.sqrt(n); i++) {
            res = Math.min(res, minimumSquare(n - i * i));
        }
        return res;
    }
}
