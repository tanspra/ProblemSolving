package org.dsa.custom.trie;

public class Test {
    public static void main(String[] args) {
//        TrieNode node = new TrieNode('A');
//        System.out.println(node.getValue());

        Trie root = new TrieImpl();
        root.insertWord("apple");
        root.insertWord("app");
        System.out.println(root.search("apple"));
        System.out.println(root.search("app"));
        root.removeWord("apple");
        System.out.println(root.search("apple"));
        System.out.println(root.search("app"));
    }
}
