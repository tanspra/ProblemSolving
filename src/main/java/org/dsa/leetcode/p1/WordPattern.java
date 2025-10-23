package org.dsa.leetcode.p1;

import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "cat dog dog fish"));
    }

    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() != s.split(" ").length)
            return false;
        List<String> list = Arrays.asList(s.split(" "));
        Set<String> mapped = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        while (i < pattern.length()) {
            char ch = pattern.charAt(i);
            String word = list.get(i);
            if (mapped.contains(word)) {
                if(map.containsKey(ch)){
                    if (!map.get(ch).equals(word))
                        return false;
                }else{
                    return false;
                }
            } else {
                if(map.containsKey(ch)){
                    return false;
                }
                mapped.add(word);
                map.put(ch, word);
            }
            i++;
        }
        return true;
    }
}
