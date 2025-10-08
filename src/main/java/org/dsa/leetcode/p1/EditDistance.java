package org.dsa.leetcode.p1;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("zoologicoarchaeologist", "zoogeologist"));
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
}
