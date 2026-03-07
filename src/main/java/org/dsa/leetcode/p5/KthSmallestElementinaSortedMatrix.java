package org.dsa.leetcode.p5;

public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new KthSmallestElementinaSortedMatrix().kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];
        while(low <= high){
            int mid = low + (high-low)/2;
            int count = lessNumberCount(matrix, mid);
            if(count < k){
               low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    private int lessNumberCount(int[][] matrix, int num){
        int m = matrix.length, n = matrix[0].length;
        int row = m-1, col = 0;
        int count = 0;
        while(row >= 0 && col < n ){
            if(matrix[row][col] > num){
                row--;
            }else if(matrix[row][col] <= num) {
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}
