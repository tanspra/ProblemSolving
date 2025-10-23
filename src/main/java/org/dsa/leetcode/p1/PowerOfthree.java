package org.dsa.leetcode.p1;

public class PowerOfthree {
    public static void main(String[] args) {
        System.out.println(new PowerOfthree().isPowerOfThree(19684));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        while (n > 3) {
            if (n % 3 == 0)
                n /= 3;
            else return false;
        }
        return n == 3;
    }
}
