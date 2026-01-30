package org.dsa.recursion;

public class MinimumNumberOfSquare {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(minimumSquare(num));
    }

    private static int minimumSquare(int n) {
        if (Math.sqrt(n) % n == 0) {
            return 1;
        }
        int res = 1 + minimumSquare(n - 1);
        for (int i = 2; i < Math.sqrt(n) ; i++) {
            res = Math.min(res, minimumSquare(n - i * i));
        }
        return res ;
    }
}
