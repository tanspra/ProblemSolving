package org.dsa.util;

import java.util.*;

public class PermuteWords {

    static Set<String> set = new HashSet<>();
    static void permute(List<String> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            set.add(String.join("", arr));
        }
    }

    public static void main(String[] args) {
        String[] words = {"word1", "word2", "word3"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        permute(wordList, 0);
        System.out.println(set);
    }


}
