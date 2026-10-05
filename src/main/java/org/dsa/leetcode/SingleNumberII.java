package org.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{2,2,3,2}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for(int num : nums){
                if((num&(1<< i)) != 0)
                    count++;
            }
            if(count % 3 != 0 )
                result |= (1<<i);
        }
        return result;
    }

   /* HashMap Approach
   public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) < 3)
                return key;
        }
        return 0;
    }*/
}