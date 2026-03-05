package org.dsa.leetcode.p1;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(100));
    }
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        if(num < 1){
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            double v = Math.log(num) / Math.log(i);
            if(v == 2.0)
                return true;
            if(v < 2.0)
                return false;
        }
        return false;
    }
    public boolean isPerfectSquare2(int num) {
        if(num == 1){
            return true;
        }
        if(num < 1){
            return false;
        }
        for(int i = 2; i <= Math.log(num)/Math.log(2); i++){
            if(num / i == i && num% i == 0)
                return true;
        }
        return false;
    }
}
