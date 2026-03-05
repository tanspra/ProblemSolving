package org.test;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(arr));
        int[] test = arr.clone();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(test));
        test[0] = 10;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(test));
        arr[1] = 100;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(test));
    }
}
