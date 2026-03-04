package org.dsa.leetcode.p5;

public class PeakIndexinaMountainArray {
    public static void main(String[] args) {
        System.out.println(new PeakIndexinaMountainArray().peakIndexInMountainArray(new int[]{0, 1, 0}));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid+1]){
                left = mid+1;
            }else if(arr[mid] > arr[mid+1]){
                ans = mid;
                right = mid-1;
            }
        }
        return ans;
    }
}
