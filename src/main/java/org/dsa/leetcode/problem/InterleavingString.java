package org.dsa.leetcode.problem;

import java.util.HashMap;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        HashMap<String, Boolean> dp = new HashMap<>();
        return dfs(0, 0, s1, s2, s3, dp);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3, HashMap<String, Boolean> dp) {
        if (i == s1.length() && j == s2.length()) return true;
        boolean ans = false;
        int k = i + j;
        String key = i + "" + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = dfs(i + 1, j, s1, s2, s3, dp);
        }
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = dfs(i, j + 1, s1, s2, s3, dp);
        }
        dp.put(key, ans);
        return ans;
    }
}
