package org.dsa.leetcode.p1;

import java.util.Arrays;

public class SpiralMatrix2 {
  public static void main(String[] args) {
    int[][] spiralmatrixList = new SpiralMatrix2().generateMatrix(4);
    System.out.println(Arrays.deepToString(spiralmatrixList));
  }
  
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
  if( n == 1){
    result[0][0] = 1;
    return result;
  }
  
    int left = 0, right = n - 1, top = 0, bottom = n - 1;
    int counter = 1;
    while (left <= right && top <= bottom) {
      // move right
      for (int col = left; col <= right; col++) {
        result[top][col] = counter;
        counter++;
      }
      top++;
      
      // move down
      for (int row = top; row <= bottom; row++) {
        result[row][right] = counter;
        counter++;
      }
      right--;
      
      // move left
      if (top <= bottom) {
        for (int col = right; col >= left; col--) {
          result[bottom][col] = counter;
          counter++;
        }
        bottom--;
      }
      
      // move up
      if (left <= right) {
        for (int row = bottom; row >= top; row--) {
          result[row][left]= counter;
          counter++;
        }
        left++;
      }
    }
  return  result;
  }
}
