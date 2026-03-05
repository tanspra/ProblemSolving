package org.dsa.leetcode.p1;

public class SortColors {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int num : nums){
            if(num == 0) zeroCount++;
            else if(num == 1) oneCount++;
            else twoCount++;
        }
        for(int i = 0; i< nums.length; i++){
            if(i < zeroCount) nums[i] = 0;
            else if(i < zeroCount + oneCount) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
