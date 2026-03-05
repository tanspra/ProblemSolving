package org.dsa.custom.trie;

public class TrieNode {
    private char value;
    private TrieNode[] children = new TrieNode[26];;
    private boolean isTerminal = false;

    public TrieNode() {
    }
    public TrieNode(char value){
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}
