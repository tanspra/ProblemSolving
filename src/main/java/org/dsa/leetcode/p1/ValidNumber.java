package org.dsa.leetcode.p1;

public class ValidNumber {
  public static void main(String[] args) {
    System.out.println(new ValidNumber().isNumber("1e+1"));
  }
  
  public boolean isNumberJava(String s) {
    try{
      if(s.equalsIgnoreCase("Infinity") || s.equalsIgnoreCase("-Infinity") || s.equalsIgnoreCase("+Infinity")){
        return false;
      }
      float v = Float.parseFloat(s);
      if(s.contains("f") || s.contains("F") ||
          s.contains("d") || s.contains("D")){
        return false;
      }
    }catch (Exception e){
      return false;
    }
    return true;
  }
  
  public boolean isNumber(String s) {
    s = s.trim();
    boolean seenDigit = false;
    boolean seenDot = false;
    boolean seenE = false;
    boolean numberAfterE = true;
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      
      if (Character.isDigit(c)) {
        seenDigit = true;
        numberAfterE = true;
      } else if (c == '+' || c == '-') {
        // Sign can only be at the beginning or right after 'e'
        if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
          return false;
        }
      } else if (c == '.') {
        // Only one dot allowed and it must appear before 'e'
        if (seenDot || seenE) {
          return false;
        }
        seenDot = true;
      } else if (c == 'e' || c == 'E') {
        // Only one 'e' allowed and must follow a digit
        if (seenE || !seenDigit) {
          return false;
        }
        seenE = true;
        numberAfterE = false; // reset: must have digit after 'e'
      } else {
        return false; // invalid character
      }
    }
    
    return seenDigit && numberAfterE;
  }
}
