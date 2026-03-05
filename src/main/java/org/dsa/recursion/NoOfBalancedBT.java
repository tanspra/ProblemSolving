package org.dsa.recursion;

public class NoOfBalancedBT {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
////        System.out.println(balancedBTs(3));
//        System.out.println(balancedBTs(30));
//        long end = System.currentTimeMillis();
//        System.out.println("time taken : " + (end - start) + " ms");
        for (int i = 1; i < 10; i++) {
            System.out.println(balancedBTs2(i));
        }
    }

    public static int balancedBTs2(int h) {
        int[] memo = new int[h + 1];
        return balancedBTsHelper(h, memo);
    }

    private static int balancedBTsHelper(int h, int[] memo) {
        if (h <= 1) {
            return 1;
        }
        if (memo[h] != 0) {
            return memo[h];
        }
        int x = balancedBTs(h - 1);
        int y = balancedBTs(h - 2);
        int mod = (int) (Math.pow(10, 9) + 7);
        int temp1 = (int) (((long) (x) * x) % mod);
        int temp2 = (int) ((2 * (long) (x) * y) % mod);
        memo[h] = (temp1 + temp2) % mod;
        return memo[h];
    }

    public static int balancedBTs(int h) {
        if (h <= 1) {
            return 1;
        }
        int x = balancedBTs(h - 1);
        int y = balancedBTs(h - 2);
        int mod = (int) (Math.pow(10, 9) + 7);
        int temp1 = (int) (((long) (x) * x) % mod);
        int temp2 = (int) ((2 * (long) (x) * y) % mod);
        return (temp1 + temp2) % mod;
    }
}
