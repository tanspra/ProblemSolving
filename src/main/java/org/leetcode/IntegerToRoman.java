package org.leetcode;

/*https://leetcode.com/problems/integer-to-roman/description/
* 12 . Integer to Roman
Medium
Topics
Companies
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
* */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(40));
    }//main

    public String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String res = "";
        res += thousands[num / 1000];
        num -= (num / 1000) * 1000;
        res += hundreds[num / 100];
        num -= (num / 100) * 100;
        res += tens[num / 10];
        num -= (num / 10) * 10;
        res += ones[num];
        return res;
    }//intToRoman
}//class


/*leetcode 2ms solution
class Solution {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        process(sb, '*', '*', 'M', num/1000);
        num = num % 1000;

        process(sb, 'M', 'D', 'C', num/100);
        num = num % 100;

        process(sb, 'C','L','X', num/10);
        num = num % 10;

        process(sb, 'X', 'V', 'I', num);

        return sb.toString();
    }


    void process(StringBuilder sb, char major, char middle, char minor, int val){
        if(val <= 3){
            for(int i = 1; i<=val; i++)
                sb.append(minor);
        }
        else if(val == 4){
            sb.append(minor);
            sb.append(middle);
        }
        else if(val == 5){
            sb.append(middle);
        }
        else if(val <= 8){
            sb.append(middle);
            for(int i = 6; i<=val; i++)
                sb.append(minor);
        }
        else if(val == 9){
            sb.append(minor);
            sb.append(major);
        }
    }
}
* */
