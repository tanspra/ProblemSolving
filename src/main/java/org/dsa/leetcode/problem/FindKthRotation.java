package org.dsa.leetcode.problem;

public class FindKthRotation {
    public static void main(String[] args) {
        System.out.println(new FindKthRotation().findKRotation(new int[]{1,2,3,4,5,6,7}));
    }
    public int findKRotation(int[] arr) {
        int n = arr.length;
        int right = n-1;
        int count = 0;
        while(arr[count] > arr[right]){
            count++;
        }
        return count;
    }
}
