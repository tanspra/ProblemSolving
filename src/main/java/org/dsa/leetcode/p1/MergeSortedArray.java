package org.dsa.leetcode.p1;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        new MergeSortedArray().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = m+n-1, counter1 = m-1, counter2 = n-1;
        while(counter1 >= 0 && counter2>=0){
            if(nums1[counter1] > nums2[counter2] ){
                nums1[counter] = nums1[counter1];
                counter1--;
            }else{
                nums1[counter] = nums2[counter2];
                counter2--;
            }
            counter--;
        }
        while(counter2 >= 0){
            nums1[counter] = nums2[counter2];
            counter2--;
            counter--;
        }
    }
}
