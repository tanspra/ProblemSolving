package org.dsa.leetcode.p1;

public class AddBinary {
  public static void main(String[] args) {
    //    System.out.println(new AddBinary().addBinary("11", "1"));
    System.out.println(new AddBinary().addBinary("101111", "10"));
  }
  
  public String addBinary(String a, String b) {
    StringBuffer result = new StringBuffer();
    int lastIndexOfA = a.length() - 1;
    int lastIndexOfB = b.length() - 1;
    //initially carry is 0
    int carry = 0;
    while (lastIndexOfA >= 0 && lastIndexOfB >= 0) {
      //initially sum is 0
      int sum = 0;
      if (a.charAt(lastIndexOfA) == '1' && b.charAt(lastIndexOfB) == '1') {
        // 1+1 = 10 sum is 0 and carry 1
        if (carry == 0) {
          sum = 0;
          carry = 1;
        } else if (carry == 1) {
          carry = 1;
          sum = 1;
        }
      } else if ((a.charAt(lastIndexOfA) == '0' && b.charAt(lastIndexOfB) == '1')
          || (a.charAt(lastIndexOfA) == '1' && b.charAt(lastIndexOfB) == '0')) {
        // 0+1 = 1 or 1+0 = 1 sum is 1 and carry 0
        if (carry == 0) {
          sum = 1;
          carry = 0;
        } else if (carry == 1) {
          carry = 1;
          sum = 0;
        }
      } else if (a.charAt(lastIndexOfA) == '0' && b.charAt(lastIndexOfB) == '0') {
        // 0+0 = 0  sum is 0 and carry 0
        if (carry == 1) {
          carry = 0;
          sum = 1;
        }
      }
      
      result.append(sum);
      lastIndexOfA--;
      lastIndexOfB--;
    }
    
    if (lastIndexOfA < 0) {
      while (carry != 0 && lastIndexOfB >= 0) {
        if (b.charAt(lastIndexOfB) == '0') {
          result.append(1);
          carry = 0;
          lastIndexOfB--;
        } else if (b.charAt(lastIndexOfB) == '1') {
          result.append(0);
          carry = 1;
          lastIndexOfB--;
        }
      }
      while (lastIndexOfB >= 0) {
        result.append(b.charAt(lastIndexOfB));
        lastIndexOfB--;
      }
    }
    if (lastIndexOfB < 0) {
      while (carry != 0 && lastIndexOfA >= 0) {
        if (a.charAt(lastIndexOfA) == '0') {
          result.append(1);
          carry = 0;
          lastIndexOfA--;
        } else if (a.charAt(lastIndexOfA) == '1') {
          result.append(0);
          carry = 1;
          lastIndexOfA--;
        }
      }
      while (lastIndexOfA >= 0) {
        result.append(a.charAt(lastIndexOfA));
        lastIndexOfA--;
      }
    }
    
    if (carry == 1) {
      result.append(1);
    }
    return result.reverse().toString();
  }
}
