package org.dsa.leetcode.p5;

import java.util.*;

public class ScrambleString {
    Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
        System.out.println(new ScrambleString().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));

//        // Find all scrambles of a word
//        List<String> scrambles = new ScrambleString().findAllScrambles("great");
//        for (String scramble : scrambles) {
//            System.out.println(scramble);
//        }
    }

    public boolean isScramble(String s1, String s2) {
        String key = s1 + "-" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        if (s1.length() != s2.length()) {
            memo.put(key, false);
            return false;
        }
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        int n = s1.length();
        int count[] = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int c: count){
            if(c != 0){
                memo.put(key,false);
                return false;
            }
        }
        
        for (int i = 1; i < n; i++) {
            String left = s1.substring(0, i);
            String s2sl = s2.substring(n - i);
            String s2nsl = s2.substring(0, i);
            String right = s1.substring(i);
            String s2sr = s2.substring(0, n - i);
            String s2nsr = s2.substring(i);
            //for swap case
            if (isScramble(left, s2sl) && isScramble(right, s2sr)) {
                memo.put(key, true);
                return true;
            }
            //for non swap case
            if (isScramble(left, s2nsl) && isScramble(right, s2nsr)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key,false);
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int n = s1.length();

        for (int i = 1; i < n; i++) {
            String left = s1.substring(0, i);
            String s2sl = s2.substring(n - i);
            String s2nsl = s2.substring(0, i);
            String right = s1.substring(i);
            String s2sr = s2.substring(0, n - i);
            String s2nsr = s2.substring(i);
            //for swap case
            if (isScramble(left, s2sl) && isScramble(right, s2sr)) return true;
            //for non swap case
            if (isScramble(left, s2nsl) && isScramble(right, s2nsr)) return true;
        }
        return false;
    }

    /**
     * Finds all scrambles (permutations) of a given word
     *
     * @param s the input string
     * @return list of all scrambles
     */
    public List<String> findAllScrambles(String s) {
        Set<String> result = new HashSet<>();
        findScrambleHelper(s.toCharArray(), 0, result);
        return new ArrayList<>(result);
    }

    /**
     * Helper method using backtracking to generate all permutations
     */
    private void findScrambleHelper(char[] chars, int index, Set<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            findScrambleHelper(chars, index + 1, result);
            swap(chars, index, i); // backtrack
        }
    }

    /**
     * Alternative method using string manipulation
     */
    public void findScramble(String s, List<String> res) {
        if (s.length() <= 1) {
            res.add(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            String remaining = s.substring(0, i) + s.substring(i + 1);

            List<String> subScrambles = new ArrayList<>();
            findScramble(remaining, subScrambles);

            for (String sub : subScrambles) {
                res.add(current + sub);
            }
        }
    }

    /**
     * Utility method to swap characters in array
     */
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}