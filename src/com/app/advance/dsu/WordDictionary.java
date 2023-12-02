package com.app.advance.dsu;

class WordDictionary {

    public TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String str) {
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
            int index;
            if (str.charAt(i) == '.') {
                int j;
                for (j = 0; j < curr.children.length; j++) {
                    if (curr.children[j] != null) {
                        break;
                    }
                }
                if (j == 26) {
                    return false;
                } else {
                    curr = curr.children[j];
                }
            } else {
                index = str.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
        }
        return (curr != null && curr.isEndOfWord);
    }
}