package org.dsa.leetcode.twopointer;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(new int[]{-2,0})));
    }
    public int[] sortedSquares(int[] nums) {
        int n =  nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        int posIndex = 0;
        int negIndex = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0){
                neg[negIndex++] = nums[i];
            }else{
                pos[posIndex++] = nums[i];
            }
        }
        for (int i = 0; i < posIndex; i++) {
            pos[i] = pos[i]*pos[i];
        }
        for (int i = 0; i < negIndex; i++) {
            neg[i] = neg[i]*neg[i];
        }
        posIndex--;
        negIndex--;
        int idx = 0;
        int counter = 0;
       while(negIndex >= 0 && idx <= posIndex){
          if(pos[idx] <= neg[negIndex]){
              nums[counter++] = pos[idx++];
          }else{
              nums[counter++] = neg[negIndex--];
          }
       }
       while(negIndex >= 0){
           nums[counter++] = neg[negIndex--];
       }
       while(idx <= posIndex){
           nums[counter++] = pos[idx++];
       }
        return nums;
    }
}
