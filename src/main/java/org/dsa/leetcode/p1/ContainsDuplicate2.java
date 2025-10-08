package org.dsa.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
             int idx = map.get(nums[i]);
             if(Math.abs(idx-i) <= k){
                 return true;
             }else{
                 map.put(nums[i] , i);
             }
            }
        }
        return false;
    }
}
