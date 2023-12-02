package org.dsa.array;

public class NoOfEvenDigitNumberInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-12, 2314, 4556, 789};
        // System.out.println(noOfEvenDigitElement(arr));
        //System.out.println(noOfDigit(0));
        System.out.println(121);
    }

    private static int noOfEvenDigitElement(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (noOfDigit(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int noOfDigit(int num) {
        int no = 0;
        if (num == 0)
            return 1;
        while (num != 0) {
            num /= 10;
            no++;
        }
        return no;
    }
}
