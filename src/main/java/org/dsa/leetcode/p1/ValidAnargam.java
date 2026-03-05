package org.dsa.leetcode.p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnargam {
    public static void main(String[] args) {
        System.out.println(new ValidAnargam().isAnagram("anagram", "anagram"));
    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap1 = new HashMap<>();
        Map<Character, Integer> countMap2 = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(countMap1.containsKey(ch)){
                countMap1.put(ch, countMap1.get(ch)+1);
            }else{
                countMap1.put(ch, 1);
            }
        }
        for(char ch : t.toCharArray()){
            if(countMap2.containsKey(ch)){
                countMap2.put(ch, countMap2.get(ch)+1);
            }else{
                countMap2.put(ch, 1);
            }
        }
        if (countMap1.size() != countMap2.size()) return false;
        for (char key : countMap1.keySet()) {
            if (!countMap2.containsKey(key) || !Objects.equals(countMap1.get(key), countMap2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
