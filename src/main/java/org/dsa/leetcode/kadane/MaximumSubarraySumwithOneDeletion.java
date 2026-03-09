package org.dsa.leetcode.kadane;

public class MaximumSubarraySumwithOneDeletion {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarraySumwithOneDeletion().maximumSum(new int[]{1,-2,0,3}));
        System.out.println(new MaximumSubarraySumwithOneDeletion().maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(new MaximumSubarraySumwithOneDeletion().maximumSum(new int[]{2,1,-2,-5,-2}));
    }
    public int maximumSum(int[] arr) {
        int ans, noDelete, oneDelete;
        ans = noDelete  = arr[0];
        oneDelete = 0;
        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            int v2 = prevOneDelete + arr[i];
            oneDelete = Math.max(prevNoDelete, v2);
            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }
        return ans;
    }
    public int maximumSum2(int[] arr) {
       int ans, noDelete, oneDelete;
       ans = noDelete  = arr[0];
       oneDelete = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            int v2;
            if(prevOneDelete == Integer.MIN_VALUE){
                v2 = arr[i];
            }else{
                v2 = prevOneDelete + arr[i];
            }
            oneDelete = Math.max(prevNoDelete, v2);
            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }
        return ans;
    }
}
