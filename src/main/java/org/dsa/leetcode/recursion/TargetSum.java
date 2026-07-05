package org.dsa.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new TargetSum().totalWays(arr, 2));
    }
    private Map<String, Integer> dp = new HashMap<>();
    public int totalWays(int[] arr, int target) {
        return totalWaysHelper(arr, target,0, 0);
    }

    private int totalWaysHelper(int[] arr, int target, int index, int currentSum) {
        if(index == arr.length) {
            return currentSum == target ? 1 : 0;
        }
        String key = index+","+currentSum;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, totalWaysHelper(arr, target, index+1, currentSum + arr[index]) + totalWaysHelper(arr, target, index+1, currentSum - arr[index]));
        return dp.get(key);
    }

//    private Map<String, Integer> dp = new HashMap<>();
//    public int totalWays(int[] arr, int target) {
//       return totalWaysHelper(arr, target,0, 0);
//    }
//
//    private int totalWaysHelper(int[] arr, int target, int index, int currentSum) {
//        if(index == arr.length) {
//            return currentSum == target ? 1 : 0;
//        }
//        String key = index+","+currentSum;
//        if(dp.containsKey(key)) {
//            return dp.get(key);
//        }
//        dp.put(key, totalWaysHelper(arr, target, index+1, currentSum + arr[index]) + totalWaysHelper(arr, target, index+1, currentSum - arr[index]));
//        return dp.get(key);
//    }


//    private int ways = 0;
//    public int totalWays(int[] arr, int target) {
//        totalWaysHelper(arr, target,arr[0] , 0);
//        totalWaysHelper(arr, target,-arr[0] , 0);
//        return ways;
//    }
//    private void totalWaysHelper(int[] arr, int target,int sum,int index) {
//        if (index == arr.length-1) {
//            if (target == sum) {
//                ways++;
//            }
//        }
//        if(index >=  arr.length-1){
//            return;
//        }
//        totalWaysHelper(arr,target,sum+arr[index+1],index+1);
//        totalWaysHelper(arr,target,sum-arr[index+1],index+1);
//    }
}
