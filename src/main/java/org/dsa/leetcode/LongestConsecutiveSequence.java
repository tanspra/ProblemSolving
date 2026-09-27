package org.dsa.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums)
            hashSet.add(num);
        int ans = 0;
        for(int num : hashSet){
            if(!hashSet.contains(num-1)){
                int current = num;
                int count = 1;
                while(hashSet.contains(current+1)){
                    current++;
                    count++;
                }
               ans = Math.max(ans,count);
            }
        }
        return ans;
    }

   /* failed due to negative value in nums array
   [0,-1]

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        boolean[] arr = new boolean[max+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = true;
        }
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i])
                count++;
            else
                count=0;
            if(count > ans)
                ans = count;
        }
        return ans;
    }*/
}
