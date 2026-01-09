package org.dsa.custom.trie;

public interface Trie {
    void insertWord(String word);
    boolean search(String word);
    void removeWord(String word);
}
