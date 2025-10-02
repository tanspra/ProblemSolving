package org.dsa.leetcode.p2;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
17. Letter Combinations of a Phone Number
Medium
Topics
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
* */
public class LetterCombinationOfPhoneNumber {

    String[] keypad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0)
            return combinations;
        StringBuilder helper = new StringBuilder();
        calculate(digits, 0, helper, combinations);
        return combinations;
    }

    public void calculate(String digits, int index, StringBuilder helper, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(helper.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < keypad[digit].length(); i++) {
            helper.append(keypad[digit].charAt(i));
            calculate(digits, index + 1, helper, combinations);
            helper.deleteCharAt(helper.length() - 1);
        }
    }
}
