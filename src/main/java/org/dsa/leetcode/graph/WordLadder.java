package org.dsa.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        for (String word : wordList) {
            map.put(word, map.getOrDefault(word, 1));
        }
        if(!map.containsKey(endWord)){
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            String currWord = curr.word;
            int currLength = curr.length;
            map.remove(currWord);
            for (int i = 0; i < currWord.length(); i++) {
                char[] charArray = currWord.toCharArray();
                char ch = charArray[i];
                for (int j = 97; j <= 122; j++) {
                    if(ch == (char)j) {
                        continue;
                    }
                    charArray[i] = (char)j;
                    String newWord = new String(charArray);
                    if(newWord.equals(endWord)){
                        return currLength+1;
                    }
                    if(map.containsKey(newWord)){
                        queue.offer(new Pair(newWord, currLength + 1));
                    }
                }
                charArray[i] = ch;
                currWord = new String(charArray);
            }
        }
        return 0;
    }
    private record Pair(String word, int length) {
    }
}
