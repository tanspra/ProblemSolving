package org.dsa.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        System.out.println(new SubarraySumsDivisiblebyK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(new SubarraySumsDivisiblebyK().subarraysDivByK(new int[]{-1,2,9}, 2));
        System.out.println(new SubarraySumsDivisiblebyK().subarraysDivByK(new int[]{-5}, 5));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) rem += k;
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
