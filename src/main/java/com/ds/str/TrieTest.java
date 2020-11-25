package com.ds.str;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TrieTest {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("abc");
        trie.add("ablm");
        trie.add("lmn");
        trie.add("ablmn");
        trie.add("lmk");
        trie.add("lmq");

        trie.search("ab");
        System.out.println(trie.isWordAvailable("lmk "));
    }
}
