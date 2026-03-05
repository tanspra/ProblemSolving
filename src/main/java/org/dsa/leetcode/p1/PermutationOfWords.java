package org.dsa.leetcode.p1;

import java.util.*;

public class PermutationOfWords {
    private static void permutaion(String p, int l, String up, Set set) {
        if (up.isEmpty()) {
            set.add(p);
            return;
        }
        String str = up.substring(0, l);
        int len = p.length() / l;
        for (int i = 0; i <= len; i++) {
            String first = p.substring(0, l * i);
            String last = p.substring(i * l);
            permutaion(first + str + last, l, up.substring(l), set);
        }
        
    }
    
    private static void permute(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            permute(first + ch + last, up.substring(1));
        }
    }
    
    public static List<Integer> findSubstring(String s, String[] words) {
        String word = "";
        List<Integer> integerList = new ArrayList<>();
        for (String str : words) {
            word = word.concat(str);
        }
        Set set = new HashSet();
        permutaion("", words[0].length(), word, set);
        int counter = 0;
        while (counter < s.length() - word.length() + 1) {
            if (set.contains(s.substring(counter, counter + word.length()))) {
                integerList.add(counter);
            }
            counter++;
        }
        return integerList;
    }
    
    public static List<Integer> findSubstringCorrect(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w = words[0].length();
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String x : words)
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        for (int i = 0; i < w; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            for (int j = i, k = i; j + w <= n; j = j + w) {
                String word = s.substring(j, j + w);
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                count++;
                
                if (count == m) {
                    if (map.equals(temp)) {
                        ans.add(k);
                    }
                    String remove = s.substring(k, k + w);
                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    k = k + w;
                }
            }//inner for loop
        }//outer for loop
        return ans;
    }//method
    
    public static void main(String[] args) {
        //        permute("", "abcd");
        //        String[] arr = {"abz","cdz","efz"};
        //        String word = "";
        //        for(String str: arr){
        //            word = word.concat(str);
        //        }
        //        Set set = new HashSet();
        //        permutaion("",arr[0].length(), word,set);
        //        System.out.println(set);
        String[] words = {"word", "good", "best", "good"};
        System.out.println(findSubstringCorrect("wordgoodgoodgoodbestword", words));
    }
}
