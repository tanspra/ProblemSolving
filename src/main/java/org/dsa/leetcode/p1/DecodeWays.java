package org.dsa.leetcode.p1;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("2101"));
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        //initialize the dp
        dp[0] = 1;
        if(s.charAt(0) == '0')
            return 0;
        else
            dp[1] = 1;
        int n = s.length();
        for (int i = 1; i < n ; i++) {
            int noOfWays =0;
            //if the digit is valid
            if(isValid(String.valueOf(s.charAt(i)))){
                noOfWays += dp[i];
            }
            //if last 2 digit is valid
            if(isValid(s.substring(i-1,i+1))){
                noOfWays += dp[i-1];
            }
            dp[i+1] = noOfWays;
        }
        return dp[s.length()];
    }
    private boolean isValid(String num){
        if(num.charAt(0) == '0')
            return false;
        return 1 <= Integer.parseInt(num) && Integer.parseInt(num) <= 26;
    }
}
