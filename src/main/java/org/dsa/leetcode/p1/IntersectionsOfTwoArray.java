package org.dsa.leetcode.p1;

import java.util.*;

public class IntersectionsOfTwoArray {
    public static void main(String[] args) {
        int[] intersection = new IntersectionsOfTwoArray().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(intersection));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
      List<Integer> list = new ArrayList<>();
        Arrays.sort(nums2);
        for(int num : nums1){
            if(binarySearch(nums2, num))
                list.add(num);
        }
       return list.stream().mapToInt(i -> i).toArray();
    }

    private boolean binarySearch(int[] nums2, int num) {
        int left = 0, right = nums2.length - 1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(num == nums2[mid])
                return true;
            if(num < nums2[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
