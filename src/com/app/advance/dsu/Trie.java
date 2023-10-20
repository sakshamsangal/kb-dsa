package com.app.advance.dsu;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            int j = str.charAt(i) - 'a';
            if (curr.children[j] == null) {
                curr.children[j] = new TrieNode();
            }
            curr = curr.children[j];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return (curr != null && curr.isEndOfWord);
    }


    public boolean startsWith(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (curr.children[index] == null) {  // char is not present
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        System.out.println("appl = " + apple);
    }
}