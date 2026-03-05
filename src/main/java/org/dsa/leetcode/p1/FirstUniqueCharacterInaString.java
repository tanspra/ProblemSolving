package org.dsa.leetcode.p1;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInaString {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInaString().firstUniqChar("aabb"));
    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0)+1);
        }
        for(char ch : map.keySet()){
            if(map.get(ch) == 1){
                return s.indexOf(ch);
            }
        }
        return -1;
    }
}
