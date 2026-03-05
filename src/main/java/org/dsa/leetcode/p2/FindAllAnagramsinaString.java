package org.dsa.leetcode.p2;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans;
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(char ch : p.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0; i < s.length() ; i++){
            freq2[s.charAt(i) - 'a']++;
            if(i >= p.length()){
                freq2[s.charAt(i - p.length()) - 'a']--;
            }
            if(match(freq, freq2)){
                ans.add(i-p.length()+1);
            }
        }

    return ans;
    }

    private boolean match(int[] freq, int[] freq2) {
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != freq2[i]) return false;
        }
        return true;
    }
}
