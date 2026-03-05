package org.dsa.leetcode.p4;

/*https://leetcode.com/problems/zigzag-conversion/description/
6. Zigzag Conversion
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
* */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("ABCDEF", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        //finding required column
        int col = 0;
        int len = s.length();
        while (len >= numRows) {
            len = len - numRows;
            col++;
            if (len > (numRows - 2)) {
                len = len - (numRows - 2);
                col += numRows - 2;
            } else {
                col += len;
                len = 0;
            }
        }
        if (len > 0) {
            col++;
            len = 0;
        }

        //adding in zigzag pattern
        char[] charArray = s.toCharArray();
        char[][] charMatrix = new char[numRows][col];
        len = s.length();
        int col2 = 0, index = 0;
        while (len >= numRows) {
            len = len - numRows;
            for (int i = 0; i < numRows; i++) {
                if (index < charArray.length) {
                    charMatrix[i][col2] = charArray[index];
                    index++;
                }

            }
            col2++;
            if (len > (numRows - 2)) {
                len = len - (numRows - 2);
                for (int i = numRows - 2; i > 0; i--) {
                    if (index < charArray.length) {
                        charMatrix[i][col2] = charArray[index];
                        index++;
                        col2++;
                    }
                }
            } else {
                int row = numRows;
                while (len > 0) {

                    if (index < charArray.length) {
                        charMatrix[row - 2][col2] = charArray[index];
                        row--;
                        col2++;
                        index++;
                        len--;
                    }
                }
            }
        }
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (index < charArray.length) charMatrix[i][col2] = charArray[index];
                index++;
            }
        }

        //reading in staright manner
        String result = "";

        for (char[] rows : charMatrix) {
            for (char ch : rows) {
                if (ch != 0) {
                    result = String.valueOf(new StringBuilder(result).append(ch));
                }
            }
        }
        return result;
    }
}
