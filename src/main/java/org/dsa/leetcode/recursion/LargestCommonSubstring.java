package org.dsa.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class LargestCommonSubstring {
    public static void main(String[] args) {
//        System.out.println(lcs("abcdef", "xyczef"));
        System.out.println(lcsDp("abcdef", "xyczef"));
    }
    private static int lcsDp(String first, String second) {
        int m  = first.length();
        int n = second.length();
        int[][] dp = new int[m+1][n+1];

        //fill first row and column
        for (int i = 0; i <=n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        //fill rest dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (first.charAt(m-i) == second.charAt(n-j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }

    private static int lcs3(String first, String second) {
        int[][] memo = new int[first.length() + 1][second.length() + 1];
        return lcsHelper3(first,second,memo);
    }

    private static int lcsHelper3(String first, String second, int[][] memo) {
        if (first.length() == 0 || second.length() == 0) {
            return 0;
        }
       int m =  first.length(), n = second.length();
        if(memo[m][n] != 0){
            return memo[m][n];
        }
        if (first.charAt(0) == second.charAt(0)) {
            memo[m][n] = 1 + lcsHelper3(first.substring(1),second.substring(1),memo);
        } else {
            int a = lcsHelper3(first.substring(1), second,memo);
            int b = lcsHelper3(first.substring(1), second.substring(1), memo);
            int c = lcsHelper3(first, second.substring(1), memo);
            int max = Math.max(a, Math.max(b, c));
            memo[m][n] = max;
        }
        return memo[m][n];
    }

    private static int lcs2(String first, String second) {
        Map<String, Integer> map = new HashMap<>();
        return lcsHelper2(first,second,map);
    }

    private static int lcsHelper2(String first, String second, Map<String, Integer> map) {
        if (first.length() == 0 || second.length() == 0) {
            return 0;
        }
        String key = first + second;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        if (first.charAt(0) == second.charAt(0)) {
            return 1 + lcsHelper2(first.substring(1), second.substring(1),map);
        } else {
            int a = lcsHelper2(first.substring(1), second,map);
            int b = lcsHelper2(first.substring(1), second.substring(1),map);
            int c = lcsHelper2(first, second.substring(1),map);
            int max = Math.max(a, Math.max(b, c));
            map.put(key, max);
            return max;
        }
    }

    private static int lcs(String first, String second) {
        if (first.length() == 0 || second.length() == 0) {
            return 0;
        }
        if (first.charAt(0) == second.charAt(0)) {
            return 1 + lcs(first.substring(1), second.substring(1));
        } else {
            int a = lcs(first.substring(1), second);
            int b = lcs(first.substring(1), second.substring(1));
            int c = lcs(first, second.substring(1));
            return Math.max(a, Math.max(b, c));
        }
    }
}
