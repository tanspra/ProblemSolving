package org.dsa.leetcode.p1;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0 | n == 1)
            return;
        int slow = 0, fast = 1;
        while (slow < n && fast < n) {
            if(nums[slow] == 0){
                if(nums[fast] != 0){
                    //swap
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    slow++;
                    fast++;
                }else{
                    fast++;
                }
            }else{
                if(nums[fast] != 0)
                    fast++;
                slow++;
            }
        }
    }
}
