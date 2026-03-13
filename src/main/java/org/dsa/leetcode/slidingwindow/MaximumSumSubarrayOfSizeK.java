package org.dsa.leetcode.slidingwindow;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(new MaximumSumSubarrayOfSizeK().maxSubarraySum(new int[]{100,200,300,400}, 2));
    }
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high= 0, maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while(high < n){
            sum+=arr[high];
           if(high-low+1==k){
               maxSum = Math.max(maxSum, sum);
               sum -= arr[low];
               high++;
               low++;
           }else {
               high++;
           }
        }
        return maxSum;
    }
}
