package org.dsa.leetcode.binarysearchalgo;

public class Numberofoccurrence {
    public static void main(String[] args) {
        System.out.println(new Numberofoccurrence().countFreq(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
    }
    int countFreq(int[] arr,
                  int target) {
        int result = 0;
        int left = binarySearch(arr,target,false);
        int right = binarySearch(arr,target,true);
        if(right != -1 && left != -1) {
            result = right - left + 1;
        }
        return result;
    }

    private int binarySearch(int[] arr, int target, boolean isrightSearch) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if(isrightSearch)
                {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
                ans = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
//    int countFreq(int[] arr, int target) {
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == target)
//                count++;
//        }
//        return count;
//    }
}
