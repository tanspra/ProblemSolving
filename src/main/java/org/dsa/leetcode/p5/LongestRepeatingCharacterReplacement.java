package org.dsa.leetcode.p5;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int maxFreq = 0;
        int[] count = new int[26];
        int result = Integer.MIN_VALUE;
        for (int high = 0; high < n; high++) {
            int currentCount = ++count[s.charAt(high) -'A'];
            maxFreq = Math.max(maxFreq, currentCount);
            while (high - low + 1 - maxFreq > k) {
                count[s.charAt(low++) - 'A']--;
            }
            result = Math.max(result, (high - low + 1));
        }
        return result;
    }

    public int characterReplacement3(String s, int k) {
        int n = s.length();
        int low = 0;
        int[] count = new int[26];
        int result = Integer.MIN_VALUE;
        for (int high = 0; high < n; high++) {
            count[s.charAt(high) -'A']++;

            while (high - low + 1 - findMax(count) > k) {
                count[s.charAt(low++) - 'A']--;
            }
            result = Math.max(result, (high - low + 1));
        }
        return result;
    }
    public int characterReplacement2(String s, int k) {
        int n = s.length();
        int low = 0;
        int[] count = new int[256];
        int result = Integer.MIN_VALUE;
        for (int high = 0; high < n; high++) {
            count[s.charAt(high)]++;

            while (high - low + 1 - findMax(count) > k) {
                count[s.charAt(low++)]--;
            }
            result = Math.max(result, (high - low + 1));
        }
        return result;
    }

    private int findMax(int[] count) {
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }

}
