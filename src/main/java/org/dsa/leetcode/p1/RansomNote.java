package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }
        return true;
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        char[] charArray = ransomNote.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char ch : charArray) {
            list.add(ch);
        }
        for (char ch : magazine.toCharArray()) {
            list.remove((Character) ch);
        }
        return list.isEmpty();
    }
}
