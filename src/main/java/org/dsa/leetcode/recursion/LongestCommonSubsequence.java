package org.dsa.leetcode.recursion;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
       int m =  text1.length();
       int n = text2.length();
       int[][] dp = new int[m+1][n+1];
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }

//    private int helper(String text1, String text2, int len1, int len2, int index1, int index2) {
//        if (index1 == len1 || index2 == len2) {
//            return 0;
//        }
//        if (text1.charAt(index1) == text2.charAt(index2)) {
//            return 1 + helper(text1, text2, len1, len2, index1 + 1, index2 + 1);
//        } else {
//            int ans1 = helper(text1, text2, len1, len2, index1 + 1, index2);
//            int ans2 = helper(text1, text2, len1, len2, index1, index2 + 1);
//            return Math.max(ans1, ans2);
//        }
//    }
}
