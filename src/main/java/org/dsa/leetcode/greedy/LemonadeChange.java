package org.dsa.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static void main(String[] args) {
//     int[] bills = {5,5,5,10,20};
//     int[] bills = {5,5,10,10,20};
        int[] bills = {5, 5, 5, 5, 20, 20, 5, 5, 20, 5};

        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean ans = true;
        int change;
        for (int bill : bills) {
            map.put(bill, map.getOrDefault(bill, 0) + 1);
            change = bill - 5;
            while (change >= 10 && map.getOrDefault(10, 0) >= 1) {
                map.computeIfPresent(10, (k, v) -> v - 1);
                change -= 10;
            }
            while (change >= 5 && map.getOrDefault(5, 0) >= 1) {
                map.computeIfPresent(5, (k, v) -> v - 1);
                change -= 5;
            }
            if (change > 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
