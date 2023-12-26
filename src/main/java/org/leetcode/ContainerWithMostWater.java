package org.leetcode;

/*https://leetcode.com/problems/container-with-most-water/description/

11. Container With Most Water
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*
* */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //twopointer approach
    private int maxArea(int[] height) {
        int maxCapacity = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int capacity = h * w;

            maxCapacity = Math.max(maxCapacity, capacity);

            // Move the pointers towards each other
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }

   /* //basic approach
    public int maxArea(int[] height) {
        int maxCapacity =0;
        for (int i = 1; i < height.length ; i++) {
            for (int j = i+1; j <= height.length ; j++) {
                int capacity = (j-i)*(Math.min(height[i-1],height[j-1] ));
                if(capacity>maxCapacity){
                    maxCapacity=capacity;
                }
            }
        }
        return maxCapacity;
}//maxArea
*/
}//class

/*
* class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = -1;
        while(left < right) {
            int h = Math.min(
                height[left], height[right]);
            max = Math.max(
                max, h * (right - left));

            while(left < right &&
            height[left] <= h){
                left++;
            }
            while(left < right &&
            height[right] <= h){
                right--;
            }
        }

        return max;
    }
}
* */
