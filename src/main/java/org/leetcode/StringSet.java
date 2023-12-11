package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringSet {
    public static void main(String[] args) {

//        subSets("cbbd").forEach(System.out::println);
//        System.out.println(subSets("cbbd").stream().count());
        combinations("", "abc");
    }

    private static List<List<Character>> subSets(String str) {
        char[] chars = str.toCharArray();

        List<List<Character>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (char ch : chars) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Character> internal = new ArrayList<>(outer.get(i));
                internal.add(ch);
                outer.add(internal);
            }
        }
        return outer;
    }//subSets

    private static List<List<Character>> subSetsDuplicate(String str) {
        char[] chars = str.toCharArray();

        List<List<Character>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (char ch : chars) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Character> internal = new ArrayList<>(outer.get(i));
                internal.add(ch);
                outer.add(internal);
            }
        }
        return outer;
    }//subSetsDuplicate


    static void combinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        //take character
        up = up.substring(1);
        combinations(p + ch, up);
        //ignore character
        combinations(p, up);
    }

}//StringSet

