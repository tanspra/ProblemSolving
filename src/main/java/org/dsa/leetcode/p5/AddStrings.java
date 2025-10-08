package org.dsa.leetcode.p5;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i= num1.length()-1, j= num2.length()-1, carry =0;

        while(i >= 0 || j>=0 || carry > 0 ){
            int x = (i >= 0)?num1.charAt(i--)-'0':0;
            int y = (j >= 0)?num2.charAt(j--)-'0':0;
            int sum =x+y+carry;
            carry=sum/10;
            res.append(sum%10);
        }
        return res.reverse().toString();
    }
}
