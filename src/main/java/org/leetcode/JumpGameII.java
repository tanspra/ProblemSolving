package org.leetcode;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[] { 2, 3, 1, 1, 4 }));
    }

    public int jump(int[] nums) {
    int currentEnd =0, jump =0, farthest =0;

    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if(i == currentEnd ){
            jump++;
            currentEnd = farthest;
        }
    }
    return jump;
    }
}
