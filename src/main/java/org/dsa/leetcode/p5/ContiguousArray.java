package org.dsa.leetcode.p5;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 0, 1, 0, 0}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    }

    public int findMaxLength(int[] nums) {
        int ones = 0, zeroes = 0, ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) ones++;
            else zeroes++;
            int diff = zeroes - ones;
            if (diff == 0) {
                ans = Math.max(ans, i + 1);
            } else if (map.containsKey(diff)) {
                ans = Math.max(ans, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return ans;
    }
}
