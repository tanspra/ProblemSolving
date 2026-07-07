package org.dsa.leetcode.recursion;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                  dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


//    private int[][] dp;
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        dp = new  int[n + 1][n + 1];
//        return helper(nums, 0, -1);
//    }
//    private int helper(int[] arr, int index, int prevIndex) {
//        if (index == arr.length) {
//            return 0;
//        }
//        if(dp[index][prevIndex+1] > 0){
//            return dp[index][prevIndex+1];
//        }
//        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
//            int c1 = 1 + helper(arr, index + 1, index);
//            int c2 = helper(arr, index + 1, prevIndex);
//            return dp[index][prevIndex+1] = Math.max(c1, c2);
//        }
//        return dp[index][prevIndex+1] = helper(arr, index + 1, prevIndex);
//    }

//    public int lengthOfLIS(int[] nums) {
//        return helper(nums, 0, -1);
//    }
//    private int helper(int[] arr, int index, int prevIndex) {
//        if (index == arr.length) {
//            return 0;
//        }
//        if(prevIndex == -1 || arr[index] > arr[prevIndex]) {
//            int c1  = 1 + helper(arr, index + 1, index);
//            int c2  = helper(arr, index + 1, prevIndex);
//            return Math.max(c1, c2);
//        }
//        return helper(arr, index + 1, prevIndex);
//    }

//    private int ans = 0;
//    public int lengthOfLIS(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            helper(nums, i, new ArrayList<>());
//        }
//        return ans;
//    }
//
//    private void helper(int[] arr, int index, List<Integer> currentSubsequence) {
//        if (index >= arr.length) {
//            ans = Math.max(ans, currentSubsequence.size());
//            return;
//        }
//        if(currentSubsequence.isEmpty()){
//            currentSubsequence.add(arr[index]);
//            helper(arr, index + 1, currentSubsequence);
//        }else{
//            int last =  currentSubsequence.get(currentSubsequence.size() - 1);
//            if(arr[index] > last){
//                currentSubsequence.add(arr[index]);
//                helper(arr, index + 1, currentSubsequence);
//                currentSubsequence.remove(currentSubsequence.size() - 1);
//                helper(arr, index + 1, currentSubsequence);
//            }else{
//                helper(arr, index + 1, currentSubsequence);
//            }
//        }
//
//    }

}
