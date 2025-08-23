package org.leetcode;

public class RemoveDuplicateFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveDuplicateFromSortedArray2().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
       int j=1;
       int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] == nums[i-1]){
               if( count < 2) {
                   nums[j] = nums[i];
                   j++;
                   count++;
               }
            }else{
                nums[j] = nums[i];
                j++;
                count = 1;
            }
        }
        return j;
    }
}
