package org.dsa.leetcode.p4;

import java.util.*;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
//        System.out.println(new SubstringWithConcatenationOfAllWords()
//                .findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));
        System.out.println(new SubstringWithConcatenationOfAllWords()
                .findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ansList = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w= words[0].length();
        HashMap<String, Integer> frequencyHashMap = new HashMap<>();
        for(String word: words){
            frequencyHashMap.put(word,frequencyHashMap.getOrDefault(word,0)+1);
        }
        for(int i=0; i<w; i++){
            HashMap<String, Integer> tempHashMap = new HashMap<>();
            int count = 0;
            for (int j = i, k = i ; j+w <= n ; j = j+w) {
                String word = s.substring(j,j+w);
                tempHashMap.put(word,tempHashMap.getOrDefault(word,0)+1);
                count++;
                if(count == m){
                    if(tempHashMap.equals(frequencyHashMap))
                        ansList.add(k);
                    String removeString = s.substring(k,k+w);
                    tempHashMap.computeIfPresent(removeString,(a,b)->b>1 ? b-1 : null);
                    count--;
                    k = k+w;
                }
            }
        }

        return ansList;
    }

    public List<Integer> findSubstringMyApproach(String s, String[] words) {
    List<Integer> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    permute(Arrays.asList(words), 0, set);
    int validSubstringLength = words[0].length()* words.length;
        for (int i = 0; i <s.length()-validSubstringLength+1 ; i++) {
            if(set.contains(s.substring(i,i+validSubstringLength))){
                list.add(i);
            }
        }
    return list;
    }

    public void permute(List<String> arr, int k, Set set) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1,set);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            set.add(String.join("", arr));
        }
    }
}
