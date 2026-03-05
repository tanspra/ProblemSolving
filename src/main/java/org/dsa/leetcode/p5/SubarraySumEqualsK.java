package org.dsa.leetcode.p5;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
//        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1,1,1},2));
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{4,5,0,-2,-3,1},5));
    }
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum = sum + num;
            count = count + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
