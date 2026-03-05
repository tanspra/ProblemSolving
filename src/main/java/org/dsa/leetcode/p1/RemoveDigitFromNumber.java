package org.dsa.leetcode.p1;

public class RemoveDigitFromNumber {
  public String removeDigit(String number, char digit) {
    int index = 0,n=number.length();
    for(int i=0;i<n;i++){
      if(number.charAt(i)==digit){
        index = i;
        if(i<n-1 && digit < number.charAt(i+1)) break;
      }
    }
    number = number.substring(0, index) + number.substring(index+1);
    return number;
  }
  
  public static void main(String[] args) {
    System.out.println(new RemoveDigitFromNumber().removeDigit("1231", '1'));
  }
}
