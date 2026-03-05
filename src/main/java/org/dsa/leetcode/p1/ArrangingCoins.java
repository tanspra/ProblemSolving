package org.dsa.leetcode.p1;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(5));
    }
    public int arrangeCoins(int n) {
        long lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) return (int) mid;
            else if (coins < n) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) hi;
    }
//    public int arrangeCoins(int n) {
//        int count = 0;
//        while(n > count){
//            count++;
//            n -= count;
//        }
//        return count;
//    }
}
