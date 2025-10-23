package org.dsa.leetcode.p1;

public class SquareRoot {
  public static void main(String[] args) {
    System.out.println(new SquareRoot().mySqrt(2147483647));
//    System.out.println(new SquareRoot().mySqrt(3025));
  }
  
  public int mySqrt(int x) {
    if (x < 2)
      return x;
    
    int left = 2, right = x / 2, ans = 1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long square = (long) mid * mid;
      if (square == x)
        return mid;
      else if (square < x) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
