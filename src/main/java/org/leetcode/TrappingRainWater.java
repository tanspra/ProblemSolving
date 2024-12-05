package org.leetcode;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{1,0,1}));
    }
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int water = 0;
        int left = 0;
        int right = n - 1;
        int maxLeft =0;
        int maxRight =0;

        while (left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= maxLeft) {
                    maxLeft = height[left];
                }else{
                    water += maxLeft - height[left];
                }
                left++;
            }else{
                if(height[right] >= maxRight) {
                    maxRight = height[right];
                }else{
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public int trapBruteForce(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            //find leftMax
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            //find rightMax
            for (int j = i ; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            //calculate trapped water at each index
            water += Math.min(rightMax , leftMax) - height[i];
        }
    return water;
    }
}
