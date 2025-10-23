package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
//    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    List<Integer> spiralmatrixList = new SpiralMatrix().spiralOrder(matrix);
    System.out.println(Arrays.toString(spiralmatrixList.toArray()));
  }
  
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0)
      return result;
    
    int m = matrix.length, n = matrix[0].length;
    int left = 0, right = n - 1, top = 0, bottom = m - 1;
    
    while (left <= right && top <= bottom) {
      // move right
      for (int col = left; col <= right; col++) {
        result.add(matrix[top][col]);
      }
      top++;
      
      // move down
      for (int row = top; row <= bottom; row++) {
        result.add(matrix[row][right]);
      }
      right--;
      
      // move left
      if (top <= bottom) {
        for (int col = right; col >= left; col--) {
          result.add(matrix[bottom][col]);
        }
        bottom--;
      }
      
      // move up
      if (left <= right) {
        for (int row = bottom; row >= top; row--) {
          result.add(matrix[row][left]);
        }
        left++;
      }
    }
    
    return result;
  }
}
