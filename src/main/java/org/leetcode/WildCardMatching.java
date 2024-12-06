package org.leetcode;

public class WildCardMatching {
    public static void main(String[] args) {
        System.out.println(new WildCardMatching().isMatch("aa", "a"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //base case emptystring should match empty pattern
        dp[0][0] = true;

        //fill for the pattern stating withh *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        //fill dp matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               char sChar = s.charAt(i - 1);
               char pChar = p.charAt(j - 1);

               if (sChar == pChar || p.charAt(j-1) == '?') {
                   dp[i][j] = dp[i - 1][j - 1];
               }else if (pChar == '*') {
                   dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
               }
            }
        }
        return dp[m][n];
    }
}
