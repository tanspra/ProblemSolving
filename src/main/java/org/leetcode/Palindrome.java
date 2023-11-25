package org.leetcode;

/*9. Palindrome Number
Easy
Topics
Companies
Hint
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1*/
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
//    public static boolean isPalindrome(int x) {
//        int number = x;
//        int revNumber=0;
//        while(number%10!=0){
//            revNumber=revNumber*10 + number%10;
//            number=number/10;
//        }
//        return x==revNumber;
//    }

    public static boolean isPalindrome(int x) {
        String number = new Integer(x).toString();
        return number.equals(new StringBuilder(number).reverse().toString());
    }
}
