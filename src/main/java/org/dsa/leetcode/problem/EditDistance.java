package org.dsa.leetcode.problem;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("abcd", "efg"));
    }

    public int minDistance(String word1, String word2) {

        //create dp
        int w1 = word1.length()+1;
        int w2 = word2.length()+1;
        int[][] dp = new int[w2][w1];

        //initially fill the dp
        for(int i= 0; i < w1; i++){
            dp[0][i] = i;
        }
        for(int i= 0; i < w2; i++){
            dp[i][0] = i;
        }
        //now fill the rest dp
        for(int i = 1; i < w2; i++){
            for (int j = 1; j < w1 ; j++) {
                if(word1.charAt(j-1) == word2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                }
            }
        }
       return dp[w2-1][w1-1];
    }

    public int minDistanceDp(String word1, String word2) {

        //create dp
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        //initially fill the dp
        for(int i= 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i= 0; i <= n; i++){
            dp[0][i] = i;
        }
        //now fill the rest dp
        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n ; j++) {
                if(word1.charAt(m-i) == word2.charAt(n-j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
