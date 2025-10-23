package org.dsa.leetcode.p1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] ints = new FairCandySwap().fairCandySwap(new int[]{1, 1}, new int[]{2, 2});
//        int[] ints = new FairCandySwap().fairCandySwap(new int[]{2}, new int[]{1,3});
        System.out.println(Arrays.toString(ints));
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
       int[] res = new int[2];
        int delta = (sumOfArray(bobSizes) - sumOfArray(aliceSizes))/2;
       Set<Integer> setB = new HashSet<>();
       for(int b: bobSizes){
       setB.add(b);
       }
       for(int a : aliceSizes){
           int y = a + delta;
           if(setB.contains(y)){
               res[0] = a;
               res[1] = y;
               return res;
           }
       }
       return res;
    }
    private int sumOfArray(int[] arr){
        return Arrays.stream(arr).sum();
    }
}
