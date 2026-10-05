package org.dsa.leetcode;

//https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{4,1,2,1,4,2,5}));
    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR cancels duplicates
        }
        return result;
    }
}
