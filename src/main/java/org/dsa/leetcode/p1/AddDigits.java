package org.dsa.leetcode.p1;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }
    public int addDigits(int num) {
        while(!isSingleDigit(num)){
            num = addAllDigit(num);
        }
        return num;
    }

    private int addAllDigit(int num) {
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    private boolean isSingleDigit(int num){
        return num >=0 && num <=9;
    }
}
