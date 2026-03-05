package org.dsa.custom.trie;

public class TrieImpl implements Trie {
    private final TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }

    @Override
    public void insertWord(String word) {
        insertWord(root, word);
    }

    @Override
    public boolean search(String word) {
        return search(root, word);
    }

    @Override
    public void removeWord(String word) {
        removeWord(root, word);
    }
    private void insertWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.setTerminal(true);
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child;
        if (root.getChildren()[index] == null) {
            child = new TrieNode(word.charAt(0));
            root.getChildren()[index] = child;
        } else {
            child = root.getChildren()[index];
        }
        insertWord(child, word.substring(1));
    }

    private boolean search(TrieNode node, String word) {
        if (word.length() == 0) {
            return node.isTerminal();
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = node.getChildren()[index];
        return child != null && search(child, word.substring(1));
    }

    private void removeWord(TrieNode node, String word){
        if(word.length() == 0){
            node.setTerminal(false);
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = node.getChildren()[index];
        if(child != null) {
            removeWord(child, word.substring(1));
            if(!child.isTerminal()){
                for (int i = 0; i < 26; i++) {
                   if(child.getChildren()[i] != null){
                       return;
                   }
                }
                node.getChildren()[index] = null;
            }
        }
    }
}
