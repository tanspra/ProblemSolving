package org.dsa.leetcode.recursion;

public class SortedArray {

    public static void main(String[] args) {
        int arr[] = { 2 , 3 , 6 , 10 , 1 };
        if (isSorted(arr, 0 ))
            System.out.println( "Yes" );
        else
            System.out.println( "No" );
    }

    private static boolean isSorted(int[] arr,int index) {
        if(arr.length-index ==0 || arr.length-index == 1){
            return true;
        }
        if(arr[index]>arr[index+1]){
            return false;
        }
        return isSorted(arr, index+1);
    }
}
