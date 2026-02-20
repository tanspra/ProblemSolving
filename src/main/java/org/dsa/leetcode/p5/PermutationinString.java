package org.dsa.leetcode.p5;

public class PermutationinString {
    public static void main(String[] args) {
        System.out.println(new PermutationinString().checkInclusion("ab", "eidbaooo"));
        System.out.println(new PermutationinString().checkInclusion("hello", "ooolleoooleh"));
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0; i < s2.length() ; i++){
            freq2[s2.charAt(i) - 'a']++;
            if(i >= s1.length()){
                freq2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if(match(freq, freq2)){
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusion3(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();
        if(k > n) return false;
        int low = 0;
        int high = k - 1;
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        while(high < n){
            int[] tempFreq = new int[26];
            for (int i = low; i <= high ; i++) {
                tempFreq[s2.charAt(i) - 'a']++;
            }
           if(match(freq, tempFreq))
               return true;
            low++; high++;
        }
        return false;
    }

    private boolean match(int[] freq, int[] tempFreq) {
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != tempFreq[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();
        if(k > n) return false;
        int low = 0;
        int high = k - 1;
        int[] freq = new int[26];
        boolean res = true;
        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }
        while(high < n){
            int[] tempFreq = freq.clone();
            for (int i = low; i <= high ; i++) {
                tempFreq[s2.charAt(i) - 'a']--;
            }
            for(int i : tempFreq){
                if(i != 0) {
                    res = false;
                    break;
                }else{
                    res = true;
                }
            }
            if(res) return res;
            low++; high++;
        }
    return res;
    }
}
