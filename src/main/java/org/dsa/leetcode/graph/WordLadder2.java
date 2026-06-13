package org.dsa.leetcode.graph;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        List<List<String>> ladders = new WordLadder2().findLadders("hit", "cog", wordList);
        List<String> wordList = new ArrayList<>(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        List<List<String>> ladders = new WordLadder2().findLadders("red", "tax", wordList);
        ladders.forEach(System.out::println);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            map.put(word, new ArrayList<>());
        }
        bfs(beginWord, endWord, wordList, map);
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, map, path, res);
        return res;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parents, List<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }
        if (!parents.containsKey(word)) return;
        for (String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> words, Map<String, List<String>> parents) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[i] = c;
                        String nextWord = new String(arr);
                        if (!words.contains(nextWord)) continue;
                        if (!visited.contains(nextWord)) {
                            if (!levelVisited.contains(nextWord)) {
                                queue.offer(nextWord);
                                levelVisited.add(nextWord);
                            }
                            parents.computeIfAbsent(nextWord, x -> new ArrayList<>()).add(word);
                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    arr[i] = original;
                }
            }
            visited.addAll(levelVisited);
        }
    }
}
