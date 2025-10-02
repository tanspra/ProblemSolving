package org.dsa.leetcode.p3;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        System.out.println(Arrays.toString(a));
        int[] b = plusOne(a);
        System.out.println(Arrays.toString(b));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // if current digit is less than 9, just add one and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // set current digit to 0 and continue to next (carry over)
            digits[i] = 0;
        }

        // if we are here, all digits were 9, e.g., [9,9,9] -> [1,0,0,0]
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

//    public static int[] plusOne(int[] digits) {
//       int number = 0;
//        for (int i = 0; i <=digits.length - 1; i++) {
//           number = number*10 + digits[i];
//       }
//        number ++;
//        int[] result = new int[digits.length + 1];
//        for (int i = result.length - 1; i >= 0; i--) {
//            result[i] = number % 10;
//            number /= 10;
//        }
//        if(result[0] == 0){
//            result = Arrays.copyOfRange(result, 1, result.length);
//        }
//        return result;
//    }
}
