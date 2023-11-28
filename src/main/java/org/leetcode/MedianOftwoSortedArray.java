package org.leetcode;

/* https://leetcode.com/problems/median-of-two-sorted-arrays/description/
* 4. Median of Two Sorted Arrays
Hard
Topics
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
* */
public class MedianOftwoSortedArray {
    public static void main(String[] args) {
        System.out.println(new MedianOftwoSortedArray().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0D;
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];

        System.arraycopy(nums1, 0, mergedArray, 0, m);
        System.arraycopy(nums2, 0, mergedArray, m, n);
        if ((m + n) % 2 != 0) {
            median = mergedArray[(m + n + 1) / 2];
        } else {
            median = (mergedArray[(m + n) / 2 - 1] + mergedArray[(m + n) / 2]) / 2.0;
        }
        return median;
    }
}
