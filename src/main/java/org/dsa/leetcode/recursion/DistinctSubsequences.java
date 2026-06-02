package org.dsa.leetcode.recursion;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
    }

    //using Tabulation
    public int numDistinct(String s, String t) {
        int m = s.length(), n =  t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +  dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    //using memoization
    Long[][] dp;
    public int numDistinct3(String s, String t) {
        dp =  new Long[s.length()][t.length()];
        return (int)dpHelper(0,0,s,t);
    }
    private long dpHelper(int i, int j, String s, String t) {
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        long ans;
        if(s.charAt(i) == t.charAt(j)){
            ans = dpHelper(i+1,j+1,s,t) + dpHelper(i+1, j , s ,t);
        }else{
            ans = dpHelper(i+1,j,s,t);
        }
        return dp[i][j] = ans;
    }

    //uding recursion
    public int numDistinct2(String s, String t) {
        return distinctHelper(s,"",t);
    }

    private int distinctHelper(String up, String p, String t) {
        if(up.length() == 0){
            if(p.equals(t)){
                return 1;
            }else{
                return 0;
            }
        }
        if(p.length() > t.length()){
            return 0;
        }
        char ch = up.charAt(0);
        return distinctHelper(up.substring(1),p,t) +  distinctHelper(up.substring(1),p+ch,t);
    }
}
