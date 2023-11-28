package org.dsa;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 56, 12};
        System.out.println(linearSearch(arr, 154));
    }

    private static int linearSearch(int arr[], int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }
}
