package org.dsa.leetcode.p1;

import java.util.*;

public class IntersectionsOfTwoArray2 {
    public static void main(String[] args) {
        int[] intersect = new IntersectionsOfTwoArray2().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(intersect));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        //insert in hash map with count
        for(int num : nums1){
            map1.put(num , map1.getOrDefault(num, 0)+1);
        }
        for(int num : nums2){
            map2.put(num , map2.getOrDefault(num, 0)+1);
        }
        //check common element and get their min count
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                for (int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++) {
                    res.add(key);
                }
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}
