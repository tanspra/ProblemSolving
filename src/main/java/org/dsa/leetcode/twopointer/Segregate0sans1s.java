package org.dsa.leetcode.twopointer;

import java.util.Arrays;

public class Segregate0sans1s {
    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 0};
        new Segregate0sans1s().segregate0and1(ints);
        System.out.println(Arrays.toString(ints));
    }
    void segregate0and1(int[] arr) {
        // code here
       int low =0 , high = arr.length-1;
       while(low < high){
           if(arr[low] == 0){
               low ++;
           }else if(arr[high] ==  1){
               high--;
           }else{
               int temp = arr[low];
               arr[low] = arr[high];
               arr[high] = temp;
           }
       }
    }
}
